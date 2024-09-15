package com.itranswarp.web.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class I18NFunctionDiffblueTest {
  /**
   * Method under test: {@link I18NFunction#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("_", (new I18NFunction()).getName());
  }
}
