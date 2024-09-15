package com.itranswarp.oauth.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AbstractOAuthConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AbstractOAuthConfiguration}
   *   <li>{@link AbstractOAuthConfiguration#setClientId(String)}
   *   <li>{@link AbstractOAuthConfiguration#setClientSecret(String)}
   *   <li>{@link AbstractOAuthConfiguration#setColor(String)}
   *   <li>{@link AbstractOAuthConfiguration#setIcon(String)}
   *   <li>{@link AbstractOAuthConfiguration#setIgnoreImage(boolean)}
   *   <li>{@link AbstractOAuthConfiguration#setName(String)}
   *   <li>{@link AbstractOAuthConfiguration#getClientId()}
   *   <li>{@link AbstractOAuthConfiguration#getClientSecret()}
   *   <li>{@link AbstractOAuthConfiguration#getColor()}
   *   <li>{@link AbstractOAuthConfiguration#getIcon()}
   *   <li>{@link AbstractOAuthConfiguration#getName()}
   *   <li>{@link AbstractOAuthConfiguration#isIgnoreImage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AbstractOAuthConfiguration actualAbstractOAuthConfiguration = new AbstractOAuthConfiguration();
    actualAbstractOAuthConfiguration.setClientId("42");
    actualAbstractOAuthConfiguration.setClientSecret("Client Secret");
    actualAbstractOAuthConfiguration.setColor("Color");
    actualAbstractOAuthConfiguration.setIcon("Icon");
    actualAbstractOAuthConfiguration.setIgnoreImage(true);
    actualAbstractOAuthConfiguration.setName("Name");
    String actualClientId = actualAbstractOAuthConfiguration.getClientId();
    String actualClientSecret = actualAbstractOAuthConfiguration.getClientSecret();
    String actualColor = actualAbstractOAuthConfiguration.getColor();
    String actualIcon = actualAbstractOAuthConfiguration.getIcon();
    String actualName = actualAbstractOAuthConfiguration.getName();

    // Assert that nothing has changed
    assertEquals("42", actualClientId);
    assertEquals("Client Secret", actualClientSecret);
    assertEquals("Color", actualColor);
    assertEquals("Icon", actualIcon);
    assertEquals("Name", actualName);
    assertTrue(actualAbstractOAuthConfiguration.isIgnoreImage());
  }
}
