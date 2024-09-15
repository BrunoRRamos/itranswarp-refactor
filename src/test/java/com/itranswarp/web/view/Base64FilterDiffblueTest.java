package com.itranswarp.web.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Base64FilterDiffblueTest {
  /**
   * Method under test: {@link Base64Filter#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("base64", (new Base64Filter()).getName());
  }
}
