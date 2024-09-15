package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BoardServiceDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link BoardService.TopicWithReplies}
   */
  @Test
  void testTopicWithRepliesNewTopicWithReplies() {
    // Arrange and Act
    BoardService.TopicWithReplies actualTopicWithReplies = new BoardService.TopicWithReplies();

    // Assert
    assertNull(actualTopicWithReplies.refType);
    assertNull(actualTopicWithReplies.content);
    assertNull(actualTopicWithReplies.name);
    assertNull(actualTopicWithReplies.userImageUrl);
    assertNull(actualTopicWithReplies.userName);
    assertNull(actualTopicWithReplies.replies);
    assertEquals(0L, actualTopicWithReplies.createdAt);
    assertEquals(0L, actualTopicWithReplies.id);
    assertEquals(0L, actualTopicWithReplies.updatedAt);
    assertEquals(0L, actualTopicWithReplies.version);
    assertEquals(0L, actualTopicWithReplies.boardId);
    assertEquals(0L, actualTopicWithReplies.refId);
    assertEquals(0L, actualTopicWithReplies.replyNumber);
    assertEquals(0L, actualTopicWithReplies.userId);
    assertFalse(actualTopicWithReplies.locked);
  }
}
