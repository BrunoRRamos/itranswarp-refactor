package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TopicBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link TopicBean}
   */
  @Test
  void testNewTopicBean() {
    // Arrange and Act
    TopicBean actualTopicBean = new TopicBean();

    // Assert
    assertNull(actualTopicBean.refType);
    assertNull(actualTopicBean.content);
    assertNull(actualTopicBean.name);
    assertEquals(0L, actualTopicBean.refId);
  }
}
