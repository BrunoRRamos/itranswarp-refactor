package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.api.Test;

class AttachmentServiceDiffblueTest {
  /**
   * Method under test: {@link AttachmentService#downloadAttachment(long, char)}
   */
  @Test
  void testDownloadAttachment() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AttachmentService()).downloadAttachment(1L, 'A'));
  }

  /**
   * Method under test: {@link AttachmentService#checkMime(String)}
   */
  @Test
  void testCheckMime() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AttachmentService()).checkMime("Mime"));
    assertThrows(ApiException.class, () -> (new AttachmentService()).checkMime(null));
    assertThrows(ApiException.class, () -> (new AttachmentService()).checkMime(""));
    assertEquals("image/gif", (new AttachmentService()).checkMime("image/gif"));
  }
}
