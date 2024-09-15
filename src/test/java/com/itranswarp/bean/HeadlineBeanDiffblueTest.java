package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class HeadlineBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link HeadlineBean}
   */
  @Test
  void testNewHeadlineBean() {
    // Arrange and Act
    HeadlineBean actualHeadlineBean = new HeadlineBean();

    // Assert
    assertNull(actualHeadlineBean.description);
    assertNull(actualHeadlineBean.name);
    assertNull(actualHeadlineBean.url);
  }
}
