package com.itranswarp.web.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UrlFilterDiffblueTest {
  /**
   * Method under test: {@link UrlFilter#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("url", (new UrlFilter()).getName());
  }
}
