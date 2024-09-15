package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RandomUtilDiffblueTest {
  /**
   * Method under test: {@link RandomUtil#createRandomBytes(int)}
   */
  @Test
  void testCreateRandomBytes() {
    // Arrange, Act and Assert
    assertEquals(3, RandomUtil.createRandomBytes(3).length);
  }
}
