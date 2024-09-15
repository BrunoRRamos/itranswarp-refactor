package com.itranswarp.oauth.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BilibiliOAuthProviderDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link BilibiliOAuthProvider.BilibiliAuthData}
   */
  @Test
  void testBilibiliAuthDataNewBilibiliAuthData() {
    // Arrange and Act
    BilibiliOAuthProvider.BilibiliAuthData actualBilibiliAuthData = new BilibiliOAuthProvider.BilibiliAuthData();

    // Assert
    assertNull(actualBilibiliAuthData.access_token);
    assertEquals(0L, actualBilibiliAuthData.expires_in);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BilibiliOAuthProvider.BilibiliAuth}
   */
  @Test
  void testBilibiliAuthNewBilibiliAuth() {
    // Arrange and Act
    BilibiliOAuthProvider.BilibiliAuth actualBilibiliAuth = new BilibiliOAuthProvider.BilibiliAuth();

    // Assert
    assertNull(actualBilibiliAuth.data);
    assertEquals(0L, actualBilibiliAuth.code);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BilibiliOAuthProvider.BilibiliUserData}
   */
  @Test
  void testBilibiliUserDataNewBilibiliUserData() {
    // Arrange and Act
    BilibiliOAuthProvider.BilibiliUserData actualBilibiliUserData = new BilibiliOAuthProvider.BilibiliUserData();

    // Assert
    assertNull(actualBilibiliUserData.face);
    assertNull(actualBilibiliUserData.name);
    assertNull(actualBilibiliUserData.openid);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BilibiliOAuthProvider.BilibiliUser}
   */
  @Test
  void testBilibiliUserNewBilibiliUser() {
    // Arrange and Act
    BilibiliOAuthProvider.BilibiliUser actualBilibiliUser = new BilibiliOAuthProvider.BilibiliUser();

    // Assert
    assertNull(actualBilibiliUser.data);
    assertEquals(0L, actualBilibiliUser.code);
  }
}
