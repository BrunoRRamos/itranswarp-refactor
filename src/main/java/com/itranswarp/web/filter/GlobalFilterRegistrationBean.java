package com.itranswarp.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Component;

import com.itranswarp.bean.SessionCookieBean;
import com.itranswarp.enums.Role;
import com.itranswarp.model.EthAuth;
import com.itranswarp.model.LocalAuth;
import com.itranswarp.model.OAuth;
import com.itranswarp.model.PasskeyAuth;
import com.itranswarp.model.User;
import com.itranswarp.oauth.OAuthProviders;
import com.itranswarp.service.AntiSpamService;
import com.itranswarp.service.EncryptService;
import com.itranswarp.service.RedisRateLimiter;
import com.itranswarp.service.UserService;
import com.itranswarp.util.CookieUtil;
import com.itranswarp.util.HttpUtil;

@Component
public class GlobalFilterRegistrationBean extends FilterRegistrationBean<Filter> {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.security.rate-limit.error-code:429}")
    int rateLimitErrorCode = 429;

    @Value("${spring.security.rate-limit.limit:3}")
    int rateLimit = 3;

    @Value("${spring.security.rate-limit.burst:10}")
    int rateLimitBurst = 10;

    @Autowired
    EncryptService encryptService;

    @Autowired
    AntiSpamService antiSpamService;

    @Autowired
    OAuthProviders oauthProviders;

    @Autowired
    UserService userService;

    @Autowired
    RedisRateLimiter rateLimiter;

    String serverId = getServerId();

    @PostConstruct
    public void init() {
        setOrder(100);
        setUrlPatterns(List.of("/*"));
        setFilter(new GlobalFilter());
    }

    private String getServerId() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.warn("could not get hostname.", e);
        }
        return "localhost";
    }

    class GlobalFilter implements Filter {
        @Override
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            setupRequestAndResponse(request, response);

            if (handleSpamCheck(request, response)) return;
            if (handleRateLimit(request, response)) return;

            User user = authenticateUser(request, response);

            if (handleManageAccess(request, response, user)) return;

            chain.doFilter(request, response);
        }

        private void setupRequestAndResponse(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, UnsupportedEncodingException {
            request.setCharacterEncoding("UTF-8");
            response.setHeader("X-Server-ID", serverId);
            if (!request.getRequestURI().startsWith("/files/")) {
                response.setCharacterEncoding("UTF-8");
            }
        }

        private boolean handleSpamCheck(HttpServletRequest request, HttpServletResponse response) {
            final String ip = HttpUtil.getIPAddress(request);
            if (antiSpamService.isSpamIp(ip)) {
                response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                return true;
            }
            return false;
        }

        private boolean handleRateLimit(HttpServletRequest request, HttpServletResponse response) {
            final String path = request.getRequestURI();
            if (path.startsWith("/static/") || path.startsWith("/files/")) {
                return false;
            }

            final String ip = HttpUtil.getIPAddress(request);
            int remaining = rateLimiter.getRateLimit("www", ip, rateLimit, rateLimitBurst);
            response.setIntHeader("X-RateLimit-Limit", rateLimit);

            if (remaining <= 0) {
                response.setIntHeader("X-RateLimit-Remaining", 0);
                response.setStatus(rateLimitErrorCode);
                return true;
            }

            response.setIntHeader("X-RateLimit-Remaining", remaining - 1);
            return false;
        }

        private User authenticateUser(HttpServletRequest request, HttpServletResponse response) {
            String cookieStr = CookieUtil.findSessionCookie(request);
            if (cookieStr == null) {
                return null;
            }

            SessionCookieBean session = CookieUtil.decodeSessionCookie(cookieStr);
            if (session == null) {
                CookieUtil.deleteSessionCookie(request, response);
                return null;
            }

            return authenticateByProvider(session, request, response);
        }

        private User authenticateByProvider(SessionCookieBean session, HttpServletRequest request, HttpServletResponse response) {
            switch (session.authProvider) {
                case "local":
                    return authenticateLocal(session, request, response);
                case "eth":
                    return authenticateEth(session, request, response);
                case "passkey":
                    return authenticatePasskey(session, request, response);
                default:
                    return authenticateOAuth(session, request, response);
            }
        }

        private User authenticateLocal(SessionCookieBean session, HttpServletRequest request, HttpServletResponse response) {
            LocalAuth auth = userService.fetchLocalAuthById(session.id);
            return validateAuth(auth, session, auth != null ? auth.passwd : null, String.valueOf(auth != null ? auth.userId : null), request, response);
        }

        private User authenticateEth(SessionCookieBean session, HttpServletRequest request, HttpServletResponse response) {
            EthAuth auth = userService.fetchEthAuthById(session.id);
            return validateAuth(auth, session, auth != null ? auth.address : null, String.valueOf(auth != null ? auth.userId : null), request, response);
        }

        private User authenticatePasskey(SessionCookieBean session, HttpServletRequest request, HttpServletResponse response) {
            PasskeyAuth auth = userService.fetchPasskeyAuth(session.id);
            return validateAuth(auth, session, auth != null ? auth.pubKey : null, String.valueOf(auth != null ? auth.userId : null), request, response);
        }

        private User authenticateOAuth(SessionCookieBean session, HttpServletRequest request, HttpServletResponse response) {
            OAuth auth = userService.fetchOAuthById(session.authProvider, session.id);
            return validateAuth(auth, session, auth != null ? auth.authToken : null, String.valueOf(auth != null ? auth.userId : null), request, response);
        }

        private User validateAuth(Object auth, SessionCookieBean session, String validationKey, String userId, HttpServletRequest request, HttpServletResponse response) {
            if (auth != null && session.validate(validationKey, encryptService.getSessionHmacKey())) {
                return userService.getEnabledUserById(Long.parseLong(userId));
            } else {
                CookieUtil.deleteSessionCookie(request, response);
                return null;
            }
        }

        private boolean handleManageAccess(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
            String uri = request.getRequestURI();
            if (!uri.startsWith("/manage/")) {
                return false;
            }

            if (user == null) {
                response.sendRedirect("/auth/signin");
                return true;
            }

            if (user.role.value > Role.CONTRIBUTOR.value) {
                logger.info("prevent access /manage/ for user {}.", user);
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return true;
            }

            return false;
        }
    }
}
