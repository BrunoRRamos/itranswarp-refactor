package com.itranswarp.web.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.common.ApiException;
import com.itranswarp.enums.ApiError;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.apache.catalina.connector.Response;
import org.apache.catalina.core.ApplicationFilterChain;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class ApiFilterRegistrationBeanDiffblueTest {
  /**
   * Method under test:
   * {@link ApiFilterRegistrationBean.ApiFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  void testApiFilterDoFilter() throws ServletException, IOException {
    // Arrange
    ApiFilterRegistrationBean.ApiFilter apiFilter = (new ApiFilterRegistrationBean()).new ApiFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    MockFilterChain chain = new MockFilterChain();

    // Act
    apiFilter.doFilter(request, response, chain);

    // Assert
    assertSame(response, chain.getResponse());
    assertSame(request, chain.getRequest());
  }

  /**
   * Method under test:
   * {@link ApiFilterRegistrationBean.ApiFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  void testApiFilterDoFilter2() throws ServletException, IOException {
    // Arrange
    ApiFilterRegistrationBean.ApiFilter apiFilter = (new ApiFilterRegistrationBean()).new ApiFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(true);

    // Act
    apiFilter.doFilter(request, response, new ApplicationFilterChain());

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals("", response.getContentAsString());
    assertNull(response.getContentType());
    assertEquals(0, response.getContentAsByteArray().length);
    assertEquals(200, response.getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(response.isCommitted());
  }

  /**
   * Method under test:
   * {@link ApiFilterRegistrationBean.ApiFilter#sendApiError(HttpServletResponse, ApiException)}
   */
  @Test
  void testApiFilterSendApiError() throws IOException {
    // Arrange
    ApiFilterRegistrationBean.ApiFilter apiFilter = (new ApiFilterRegistrationBean()).new ApiFilter();

    MockHttpServletResponse httpResponse = new MockHttpServletResponse();
    httpResponse.setCommitted(true);

    // Act
    apiFilter.sendApiError(httpResponse, new ApiException(ApiError.PARAMETER_INVALID));

    // Assert that nothing has changed
    Collection<String> headerNames = httpResponse.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals("", httpResponse.getContentAsString());
    assertEquals(0, httpResponse.getContentAsByteArray().length);
    assertEquals(200, httpResponse.getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(httpResponse.isCommitted());
  }
}
