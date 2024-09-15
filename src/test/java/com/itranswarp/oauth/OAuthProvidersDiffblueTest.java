package com.itranswarp.oauth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.oauth.provider.AbstractOAuthConfiguration;
import java.util.Map;
import org.junit.jupiter.api.Test;

class OAuthProvidersDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OAuthProviders#getOAuthConfigurations()}
   *   <li>{@link OAuthProviders#getOAuthProviders()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    OAuthProviders oAuthProviders = new OAuthProviders();

    // Act
    Map<String, AbstractOAuthConfiguration> actualOAuthConfigurations = oAuthProviders.getOAuthConfigurations();

    // Assert
    assertNull(oAuthProviders.getOAuthProviders());
    assertNull(actualOAuthConfigurations);
  }

  /**
   * Method under test:
   * {@link OAuthProviders.OAuthInfo#OAuthInfo(String, AbstractOAuthConfiguration)}
   */
  @Test
  void testOAuthInfoNewOAuthInfo() {
    // Arrange
    AbstractOAuthConfiguration oauthConfiguration = new AbstractOAuthConfiguration();
    oauthConfiguration.setClientId("42");
    oauthConfiguration.setClientSecret("Client Secret");
    oauthConfiguration.setColor("Color");
    oauthConfiguration.setIcon("Icon");
    oauthConfiguration.setIgnoreImage(true);
    oauthConfiguration.setName("Name");

    // Act and Assert
    AbstractOAuthConfiguration abstractOAuthConfiguration = (new OAuthProviders.OAuthInfo("42",
        oauthConfiguration)).oauthConfiguration;
    assertEquals("42", abstractOAuthConfiguration.getClientId());
    assertEquals("Client Secret", abstractOAuthConfiguration.getClientSecret());
    assertEquals("Color", abstractOAuthConfiguration.getColor());
    assertEquals("Icon", abstractOAuthConfiguration.getIcon());
    assertEquals("Name", abstractOAuthConfiguration.getName());
    assertTrue(abstractOAuthConfiguration.isIgnoreImage());
  }
}
