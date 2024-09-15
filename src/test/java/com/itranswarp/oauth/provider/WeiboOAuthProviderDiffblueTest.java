package com.itranswarp.oauth.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class WeiboOAuthProviderDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link WeiboOAuthProvider.WeiboAuth}
   */
  @Test
  void testWeiboAuthNewWeiboAuth() {
    // Arrange and Act
    WeiboOAuthProvider.WeiboAuth actualWeiboAuth = new WeiboOAuthProvider.WeiboAuth();

    // Assert
    assertNull(actualWeiboAuth.access_token);
    assertNull(actualWeiboAuth.uid);
    assertEquals(0L, actualWeiboAuth.expires_in);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link WeiboOAuthProvider.WeiboUser}
   */
  @Test
  void testWeiboUserNewWeiboUser() {
    // Arrange and Act
    WeiboOAuthProvider.WeiboUser actualWeiboUser = new WeiboOAuthProvider.WeiboUser();

    // Assert
    assertNull(actualWeiboUser.domain);
    assertNull(actualWeiboUser.idstr);
    assertNull(actualWeiboUser.profile_image_url);
    assertNull(actualWeiboUser.screen_name);
  }
}
