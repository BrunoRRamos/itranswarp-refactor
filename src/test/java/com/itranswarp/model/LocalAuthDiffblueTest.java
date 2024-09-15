package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class LocalAuthDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link LocalAuth}
   */
  @Test
  void testNewLocalAuth() {
    // Arrange and Act
    LocalAuth actualLocalAuth = new LocalAuth();

    // Assert
    assertNull(actualLocalAuth.passwd);
    assertNull(actualLocalAuth.salt);
    assertEquals(0L, actualLocalAuth.createdAt);
    assertEquals(0L, actualLocalAuth.id);
    assertEquals(0L, actualLocalAuth.updatedAt);
    assertEquals(0L, actualLocalAuth.version);
    assertEquals(0L, actualLocalAuth.userId);
  }
}
