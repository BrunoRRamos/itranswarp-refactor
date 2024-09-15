package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ImageBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link ImageBean}
   */
  @Test
  void testNewImageBean() {
    // Arrange and Act
    ImageBean actualImageBean = new ImageBean();

    // Assert
    assertNull(actualImageBean.image);
    assertNull(actualImageBean.mime);
    assertEquals(0, actualImageBean.height);
    assertEquals(0, actualImageBean.width);
    assertEquals(0L, actualImageBean.size);
  }
}
