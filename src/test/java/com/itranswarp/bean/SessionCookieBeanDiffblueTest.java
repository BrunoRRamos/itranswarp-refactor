package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SessionCookieBeanDiffblueTest {
  /**
   * Method under test:
   * {@link SessionCookieBean#SessionCookieBean(String, long, long, String)}
   */
  @Test
  void testNewSessionCookieBean() {
    // Arrange and Act
    SessionCookieBean actualSessionCookieBean = new SessionCookieBean("Auth Provider", 1L, 1L, "Hash");

    // Assert
    assertEquals("Auth Provider", actualSessionCookieBean.authProvider);
    assertEquals("Hash", actualSessionCookieBean.hash);
    assertEquals(1L, actualSessionCookieBean.expiresAt);
    assertEquals(1L, actualSessionCookieBean.id);
  }

  /**
   * Method under test: {@link SessionCookieBean#validate(String, String)}
   */
  @Test
  void testValidate() {
    // Arrange, Act and Assert
    assertFalse((new SessionCookieBean("Auth Provider", 1L, 1L, "Hash")).validate("ABC123", "Hmac Key"));
    assertTrue((new SessionCookieBean("Auth Provider", 1L, 1L,
        "5ee980fa991069b5c03a25d55e950c0d5cec5dcbb76235a1d3be2e75ddedb525")).validate("ABC123", "Hmac Key"));
  }
}
