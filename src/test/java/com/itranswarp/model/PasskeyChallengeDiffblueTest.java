package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PasskeyChallengeDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyChallenge}
   */
  @Test
  void testNewPasskeyChallenge() {
    // Arrange and Act
    PasskeyChallenge actualPasskeyChallenge = new PasskeyChallenge();

    // Assert
    assertNull(actualPasskeyChallenge.challenge);
    assertEquals(0L, actualPasskeyChallenge.createdAt);
    assertEquals(0L, actualPasskeyChallenge.id);
    assertEquals(0L, actualPasskeyChallenge.updatedAt);
    assertEquals(0L, actualPasskeyChallenge.version);
    assertEquals(0L, actualPasskeyChallenge.expiresAt);
  }
}
