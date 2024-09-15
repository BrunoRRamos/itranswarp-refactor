package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class EncryptServiceDiffblueTest {
  /**
   * Method under test: {@link EncryptService#init()}
   */
  @Test
  void testInit() {
    // Arrange
    EncryptService encryptService = new EncryptService();

    // Act
    encryptService.init();

    // Assert
    assertEquals("ed53d532820fb286f284dea6ffd029c534a03b99678aca17fc6079cfddeb8b80",
        encryptService.getSessionHmacKey());
  }

  /**
   * Method under test: {@link EncryptService#getSessionHmacKey()}
   */
  @Test
  void testGetSessionHmacKey() {
    // Arrange, Act and Assert
    assertNull((new EncryptService()).getSessionHmacKey());
  }
}
