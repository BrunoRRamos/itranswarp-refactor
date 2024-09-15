package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AbstractEntityDiffblueTest {
  /**
   * Method under test: {@link AbstractEntity#preUpdate()}
   */
  @Test
  void testPreUpdate() {
    // Arrange
    AdMaterial adMaterial = new AdMaterial();

    // Act
    adMaterial.preUpdate();

    // Assert
    assertEquals(1L, adMaterial.version);
  }
}
