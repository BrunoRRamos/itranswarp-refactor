package com.itranswarp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ApplicationDiffblueTest {
  /**
   * Method under test: {@link Application#createZoneId(String)}
   */
  @Test
  void testCreateZoneId() throws Exception {
    // Arrange, Act and Assert
    assertEquals("UTC", (new Application()).createZoneId("UTC").toString());
  }
}
