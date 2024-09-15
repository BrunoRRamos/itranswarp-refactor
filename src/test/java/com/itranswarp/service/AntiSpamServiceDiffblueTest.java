package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class AntiSpamServiceDiffblueTest {
  /**
   * Method under test: {@link AntiSpamService#isSpamIp(String)}
   */
  @Test
  void testIsSpamIp() {
    // Arrange, Act and Assert
    assertFalse((new AntiSpamService()).isSpamIp("127.0.0.1"));
  }

  /**
   * Method under test: {@link AntiSpamService#isSpamText(String)}
   */
  @Test
  void testIsSpamText() {
    // Arrange, Act and Assert
    assertFalse((new AntiSpamService()).isSpamText("Text"));
  }

  /**
   * Method under test: {@link AntiSpamService#normalize(String)}
   */
  @Test
  void testNormalize() {
    // Arrange, Act and Assert
    assertEquals("text", (new AntiSpamService()).normalize("Text"));
    assertEquals("", (new AntiSpamService()).normalize("　"));
    assertEquals("text", (new AntiSpamService()).normalize("　Text"));
    assertEquals("", (new AntiSpamService()).normalize("　　"));
  }
}
