package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TopicDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Topic}
   */
  @Test
  void testNewTopic() {
    // Arrange and Act
    Topic actualTopic = new Topic();

    // Assert
    assertNull(actualTopic.refType);
    assertNull(actualTopic.content);
    assertNull(actualTopic.name);
    assertNull(actualTopic.userImageUrl);
    assertNull(actualTopic.userName);
    assertEquals(0L, actualTopic.createdAt);
    assertEquals(0L, actualTopic.id);
    assertEquals(0L, actualTopic.updatedAt);
    assertEquals(0L, actualTopic.version);
    assertEquals(0L, actualTopic.boardId);
    assertEquals(0L, actualTopic.refId);
    assertEquals(0L, actualTopic.replyNumber);
    assertEquals(0L, actualTopic.userId);
    assertFalse(actualTopic.locked);
  }
}
