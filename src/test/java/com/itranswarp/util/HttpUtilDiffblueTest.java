package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.RemoteIpFilter;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class HttpUtilDiffblueTest {
  /**
   * Method under test: {@link HttpUtil.DevicePattern#matches(String)}
   */
  @Test
  void testDevicePatternMatches() {
    // Arrange, Act and Assert
    assertTrue((new HttpUtil.DevicePattern("https://example.org/example", "https://example.org/example"))
        .matches("https://example.org/example"));
    assertFalse((new HttpUtil.DevicePattern("https://example.org/example", "https://exampleUorg/example"))
        .matches("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link HttpUtil.DevicePattern#DevicePattern(String, String)}
   */
  @Test
  void testDevicePatternNewDevicePattern() {
    // Arrange and Act
    HttpUtil.DevicePattern actualDevicePattern = new HttpUtil.DevicePattern("https://example.org/example",
        "https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", actualDevicePattern.pattern.pattern());
    assertEquals("https://example.org/example", actualDevicePattern.name);
  }

  /**
   * Method under test: {@link HttpUtil#getOrigin(HttpServletRequest)}
   */
  @Test
  void testGetOrigin() {
    // Arrange, Act and Assert
    assertEquals("http://localhost", HttpUtil.getOrigin(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#getHost(HttpServletRequest)}
   */
  @Test
  void testGetHost() {
    // Arrange, Act and Assert
    assertEquals("localhost", HttpUtil.getHost(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#getHostname(HttpServletRequest)}
   */
  @Test
  void testGetHostname() {
    // Arrange, Act and Assert
    assertEquals("localhost", HttpUtil.getHostname(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#getScheme(HttpServletRequest)}
   */
  @Test
  void testGetScheme() {
    // Arrange, Act and Assert
    assertEquals("http", HttpUtil.getScheme(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#getReferer(HttpServletRequest)}
   */
  @Test
  void testGetReferer() {
    // Arrange, Act and Assert
    assertEquals("/", HttpUtil.getReferer(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#getDevice(HttpServletRequest)}
   */
  @Test
  void testGetDevice() {
    // Arrange, Act and Assert
    assertEquals("Unknown", HttpUtil.getDevice(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#isSecure(HttpServletRequest)}
   */
  @Test
  void testIsSecure() {
    // Arrange, Act and Assert
    assertFalse(HttpUtil.isSecure(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#isSecure(HttpServletRequest)}
   */
  @Test
  void testIsSecure2() {
    // Arrange
    RemoteIpFilter.XForwardedRequest request = new RemoteIpFilter.XForwardedRequest(new MockHttpServletRequest());
    request.setScheme("https");

    // Act and Assert
    assertTrue(HttpUtil.isSecure(request));
  }

  /**
   * Method under test: {@link HttpUtil#getIPLocation(HttpServletRequest)}
   */
  @Test
  void testGetIPLocation() {
    // Arrange, Act and Assert
    assertEquals("UNKNOWN", HttpUtil.getIPLocation(new MockHttpServletRequest()));
  }

  /**
   * Method under test: {@link HttpUtil#getUserAgent(HttpServletRequest)}
   */
  @Test
  void testGetUserAgent() {
    // Arrange, Act and Assert
    assertEquals("", HttpUtil.getUserAgent(new MockHttpServletRequest()));
  }
}
