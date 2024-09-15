package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class IdUtilDiffblueTest {
  /**
   * Method under test: {@link IdUtil#stringIdToLongId(String)}
   */
  @Test
  void testStringIdToLongId() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> IdUtil.stringIdToLongId("42"));
    assertEquals(2095166658076683257L, IdUtil.stringIdToLongId("99999999999999999999999999999999999999999999999999"));
  }
}
