package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.model.EthAuth;
import com.itranswarp.model.LocalAuth;
import com.itranswarp.model.OAuth;
import com.itranswarp.model.PasskeyAuth;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockCookie;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class CookieUtilDiffblueTest {
  /**
   * Method under test:
   * {@link CookieUtil#encodeSessionCookie(EthAuth, long, String)}
   */
  @Test
  void testEncodeSessionCookie() {
    // Arrange, Act and Assert
    assertEquals("ZXRoOjA6MTo5YjBlOTlhYTU3MWU5M2ZjYzkxOGQxYTIyY2YwMjdhNTc2OWQ1ZmJkZjIwZjNhOWVjODEzNTBkZmI5Y2QxMzg4",
        CookieUtil.encodeSessionCookie(new EthAuth(), 1L, "Hmac Key"));
    assertEquals("bG9jYWw6MDoxOjUzOGJiZDY3ZmM4NTkxMGU3Y2U3YjhhMTZlZDFjNjgyMjQxYTI5OTQzN2YxNTlmZDJkZDBiM2ZkMjQzNzdlNjU",
        CookieUtil.encodeSessionCookie(new LocalAuth(), 1L, "Hmac Key"));
    assertEquals("bnVsbDowOjA6ZTAzNDhmMzUzNTQwOTIxZjFjYWNiMmRjYzY0MmUzZWY0NTQ1NmJlYmQ2MTU2ZDM3ZDNmNmIzNTcwMGQzYTQxZg",
        CookieUtil.encodeSessionCookie(new OAuth(), "Hmac Key"));
    assertEquals(
        "cGFzc2tleTowOjE6OTRhNWMyZjc1MGMwMTBiNDFhMmJhZDVlMDQ3ODdkYTY5ZTgzNjQ0ZGQyMzg2ZGM5ZDUzYzZkZjFj" + "YWYwZjE4NA",
        CookieUtil.encodeSessionCookie(new PasskeyAuth(), 1L, "Hmac Key"));
    assertEquals("NDI6MToxOjUwNDVlZmRmNGFhOGRkZTU4OGU1MzVjNDg3ZTdiODkzODg2NmMxOGExNDE4MDkxNzQzMWYzMzM3MDlmYTI1N2E",
        CookieUtil.encodeSessionCookie("42", 1L, 1L, "ABC123", "Hmac Key"));
  }

  /**
   * Method under test: {@link CookieUtil#findSessionCookie(HttpServletRequest)}
   */
  @Test
  void testFindSessionCookie() {
    // Arrange, Act and Assert
    assertNull(CookieUtil.findSessionCookie(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link CookieUtil#findSessionCookie(HttpServletRequest)}
   */
  @Test
  void testFindSessionCookie2() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertNull(CookieUtil.findSessionCookie(request));
  }

  /**
   * Method under test: {@link CookieUtil#findSessionCookie(HttpServletRequest)}
   */
  @Test
  void testFindSessionCookie3() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(new MockCookie("_session_", "42"));

    // Act and Assert
    assertEquals("42", CookieUtil.findSessionCookie(request));
  }

  /**
   * Method under test: {@link CookieUtil#decodeSessionCookie(String)}
   */
  @Test
  void testDecodeSessionCookie() {
    // Arrange, Act and Assert
    assertNull(CookieUtil.decodeSessionCookie("Str"));
    assertNull(CookieUtil.decodeSessionCookie("\\:"));
  }

  /**
   * Method under test:
   * {@link CookieUtil#deleteSessionCookie(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testDeleteSessionCookie() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    CookieUtil.deleteSessionCookie(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    Cookie[] cookies = response.getCookies();
    Cookie cookie = cookies[0];
    assertEquals("-deleted-", cookie.getValue());
    assertEquals("/", cookie.getPath());
    Map<String, String> attributes = cookie.getAttributes();
    assertEquals(4, attributes.size());
    assertEquals("/", attributes.get("Path"));
    assertEquals("0", attributes.get("Max-Age"));
    assertEquals("_session_", cookie.getName());
    assertNull(cookie.getComment());
    assertNull(cookie.getDomain());
    assertEquals(0, cookie.getMaxAge());
    assertEquals(0, cookie.getVersion());
    assertEquals(1, cookies.length);
    assertFalse(cookie.getSecure());
    assertTrue(headerNames.contains("Set-Cookie"));
    String expectedGetResult = Boolean.FALSE.toString();
    assertEquals(expectedGetResult, attributes.get("Secure"));
    String expectedGetResult2 = Boolean.TRUE.toString();
    assertEquals(expectedGetResult2, attributes.get("HttpOnly"));
  }

  /**
   * Method under test:
   * {@link CookieUtil#setSessionCookie(HttpServletRequest, HttpServletResponse, String, int)}
   */
  @Test
  void testSetSessionCookie() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    CookieUtil.setSessionCookie(request, response, "Cookie Str", 3);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    Cookie[] cookies = response.getCookies();
    Cookie cookie = cookies[0];
    assertEquals("/", cookie.getPath());
    Map<String, String> attributes = cookie.getAttributes();
    assertEquals(4, attributes.size());
    assertEquals("/", attributes.get("Path"));
    assertEquals("3", attributes.get("Max-Age"));
    assertEquals("Cookie Str", cookie.getValue());
    assertEquals("_session_", cookie.getName());
    assertNull(cookie.getComment());
    assertNull(cookie.getDomain());
    assertEquals(0, cookie.getVersion());
    assertEquals(1, cookies.length);
    assertEquals(3, cookie.getMaxAge());
    assertFalse(cookie.getSecure());
    assertTrue(headerNames.contains("Set-Cookie"));
    String expectedGetResult = Boolean.FALSE.toString();
    assertEquals(expectedGetResult, attributes.get("Secure"));
    String expectedGetResult2 = Boolean.TRUE.toString();
    assertEquals(expectedGetResult2, attributes.get("HttpOnly"));
  }
}
