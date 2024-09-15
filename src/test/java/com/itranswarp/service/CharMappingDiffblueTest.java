package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CharMappingDiffblueTest {
  /**
   * Method under test: {@link CharMapping#CharMapping(String, char)}
   */
  @Test
  void testNewCharMapping() {
    // Arrange and Act
    CharMapping actualCharMapping = new CharMapping("jane.doe@example.org", 'A');

    // Assert
    assertEquals("jane.doe@example.org", actualCharMapping.from);
    assertEquals('A', actualCharMapping.to);
  }
}
