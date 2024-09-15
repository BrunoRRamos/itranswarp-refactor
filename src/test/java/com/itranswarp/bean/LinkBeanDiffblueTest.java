package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class LinkBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link LinkBean}
   */
  @Test
  void testNewLinkBean() {
    // Arrange and Act
    LinkBean actualLinkBean = new LinkBean();

    // Assert
    assertNull(actualLinkBean.name);
    assertNull(actualLinkBean.url);
  }
}
