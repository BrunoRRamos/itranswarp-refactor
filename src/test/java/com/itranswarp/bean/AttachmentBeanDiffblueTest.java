package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AttachmentBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link AttachmentBean}
   */
  @Test
  void testNewAttachmentBean() {
    // Arrange and Act
    AttachmentBean actualAttachmentBean = new AttachmentBean();

    // Assert
    assertNull(actualAttachmentBean.data);
    assertNull(actualAttachmentBean.name);
  }
}
