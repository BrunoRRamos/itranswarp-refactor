package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.api.Test;

class ImageUtilDiffblueTest {
  /**
   * Method under test: {@link ImageUtil#checkFormat(String)}
   */
  @Test
  void testCheckFormat() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> ImageUtil.checkFormat("Format"));
    assertThrows(ApiException.class, () -> ImageUtil.checkFormat(null));
    assertEquals("gif", ImageUtil.checkFormat("gif"));
  }
}
