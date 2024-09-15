package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ReplyBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link ReplyBean}
   */
  @Test
  void testNewReplyBean() {
    // Arrange, Act and Assert
    assertNull((new ReplyBean()).content);
  }
}
