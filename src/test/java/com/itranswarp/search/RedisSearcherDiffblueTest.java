package com.itranswarp.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RedisSearcherDiffblueTest {
  /**
   * Method under test: {@link RedisSearcher#getEngineName()}
   */
  @Test
  void testGetEngineName() {
    // Arrange, Act and Assert
    assertEquals("RediSearch", (new RedisSearcher()).getEngineName());
  }
}
