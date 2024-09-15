package com.itranswarp.web.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class IconFilterDiffblueTest {
  /**
   * Method under test: {@link IconFilter#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("icon", (new IconFilter()).getName());
  }
}
