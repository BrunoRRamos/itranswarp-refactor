package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class OAuthDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link OAuth}
   */
  @Test
  void testNewOAuth() {
    // Arrange and Act
    OAuth actualOAuth = new OAuth();

    // Assert
    assertNull(actualOAuth.authId);
    assertNull(actualOAuth.authProviderId);
    assertNull(actualOAuth.authToken);
    assertEquals(0L, actualOAuth.createdAt);
    assertEquals(0L, actualOAuth.id);
    assertEquals(0L, actualOAuth.updatedAt);
    assertEquals(0L, actualOAuth.version);
    assertEquals(0L, actualOAuth.expiresAt);
    assertEquals(0L, actualOAuth.userId);
    assertFalse(actualOAuth.isNew);
  }
}
