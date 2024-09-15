package com.itranswarp.oauth.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class QQOAuthProviderDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link QQOAuthProvider.QQAuth}
   */
  @Test
  void testQQAuthNewQQAuth() {
    // Arrange and Act
    QQOAuthProvider.QQAuth actualQqAuth = new QQOAuthProvider.QQAuth();

    // Assert
    assertNull(actualQqAuth.access_token);
    assertEquals(0, actualQqAuth.error);
    assertEquals(0L, actualQqAuth.expires_in);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link QQOAuthProvider.QQOpenId}
   */
  @Test
  void testQQOpenIdNewQQOpenId() {
    // Arrange and Act
    QQOAuthProvider.QQOpenId actualQqOpenId = new QQOAuthProvider.QQOpenId();

    // Assert
    assertNull(actualQqOpenId.openid);
    assertEquals(0, actualQqOpenId.error);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link QQOAuthProvider.QQUser}
   */
  @Test
  void testQQUserNewQQUser() {
    // Arrange and Act
    QQOAuthProvider.QQUser actualQqUser = new QQOAuthProvider.QQUser();

    // Assert
    assertNull(actualQqUser.figureurl);
    assertNull(actualQqUser.figureurl_1);
    assertNull(actualQqUser.figureurl_qq_1);
    assertNull(actualQqUser.figureurl_qq_2);
    assertNull(actualQqUser.msg);
    assertNull(actualQqUser.nickname);
    assertEquals(0, actualQqUser.ret);
  }
}
