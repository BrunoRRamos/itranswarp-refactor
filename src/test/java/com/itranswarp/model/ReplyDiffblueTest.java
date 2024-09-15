package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ReplyDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Reply}
   */
  @Test
  void testNewReply() {
    // Arrange and Act
    Reply actualReply = new Reply();

    // Assert
    assertNull(actualReply.content);
    assertNull(actualReply.userImageUrl);
    assertNull(actualReply.userName);
    assertEquals(0L, actualReply.createdAt);
    assertEquals(0L, actualReply.id);
    assertEquals(0L, actualReply.updatedAt);
    assertEquals(0L, actualReply.version);
    assertEquals(0L, actualReply.topicId);
    assertEquals(0L, actualReply.userId);
  }
}
