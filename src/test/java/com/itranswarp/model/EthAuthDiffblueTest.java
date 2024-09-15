package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class EthAuthDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link EthAuth}
   */
  @Test
  void testNewEthAuth() {
    // Arrange and Act
    EthAuth actualEthAuth = new EthAuth();

    // Assert
    assertNull(actualEthAuth.address);
    assertEquals(0L, actualEthAuth.createdAt);
    assertEquals(0L, actualEthAuth.id);
    assertEquals(0L, actualEthAuth.updatedAt);
    assertEquals(0L, actualEthAuth.version);
    assertEquals(0L, actualEthAuth.expiresAt);
    assertEquals(0L, actualEthAuth.userId);
  }
}
