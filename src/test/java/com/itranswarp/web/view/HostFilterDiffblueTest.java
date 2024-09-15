package com.itranswarp.web.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HostFilterDiffblueTest {
  /**
   * Method under test: {@link HostFilter#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("host", (new HostFilter()).getName());
  }
}
