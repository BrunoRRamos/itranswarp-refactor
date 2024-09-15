package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class DownloadBeanDiffblueTest {
  /**
   * Method under test: {@link DownloadBean#DownloadBean(String, byte[])}
   */
  @Test
  void testNewDownloadBean() throws UnsupportedEncodingException {
    // Arrange and Act
    DownloadBean actualDownloadBean = new DownloadBean("Mime", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("Mime", actualDownloadBean.mime);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDownloadBean.data);
  }
}
