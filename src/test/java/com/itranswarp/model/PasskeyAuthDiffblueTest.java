package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PasskeyAuthDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyAuth}
   */
  @Test
  void testNewPasskeyAuth() {
    // Arrange and Act
    PasskeyAuth actualPasskeyAuth = new PasskeyAuth();

    // Assert
    assertNull(actualPasskeyAuth.credentialId);
    assertNull(actualPasskeyAuth.device);
    assertNull(actualPasskeyAuth.pubKey);
    assertNull(actualPasskeyAuth.transports);
    assertEquals(0, actualPasskeyAuth.alg);
    assertEquals(0L, actualPasskeyAuth.createdAt);
    assertEquals(0L, actualPasskeyAuth.id);
    assertEquals(0L, actualPasskeyAuth.updatedAt);
    assertEquals(0L, actualPasskeyAuth.version);
    assertEquals(0L, actualPasskeyAuth.userId);
  }
}
