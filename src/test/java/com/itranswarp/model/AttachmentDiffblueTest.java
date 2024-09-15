package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AttachmentDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Attachment}
   */
  @Test
  void testNewAttachment() {
    // Arrange and Act
    Attachment actualAttachment = new Attachment();

    // Assert
    assertNull(actualAttachment.mime);
    assertNull(actualAttachment.name);
    assertEquals(0, actualAttachment.height);
    assertEquals(0, actualAttachment.width);
    assertEquals(0L, actualAttachment.createdAt);
    assertEquals(0L, actualAttachment.id);
    assertEquals(0L, actualAttachment.updatedAt);
    assertEquals(0L, actualAttachment.version);
    assertEquals(0L, actualAttachment.resourceId);
    assertEquals(0L, actualAttachment.size);
    assertEquals(0L, actualAttachment.userId);
  }
}
