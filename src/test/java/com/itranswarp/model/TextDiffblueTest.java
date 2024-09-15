package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TextDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Text}
   */
  @Test
  void testNewText() {
    // Arrange and Act
    Text actualText = new Text();

    // Assert
    assertNull(actualText.content);
    assertNull(actualText.hash);
    assertEquals(0L, actualText.createdAt);
    assertEquals(0L, actualText.id);
    assertEquals(0L, actualText.updatedAt);
    assertEquals(0L, actualText.version);
  }
}
