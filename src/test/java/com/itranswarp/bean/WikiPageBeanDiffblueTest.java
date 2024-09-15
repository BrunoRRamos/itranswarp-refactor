package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class WikiPageBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link WikiPageBean}
   */
  @Test
  void testNewWikiPageBean() {
    // Arrange and Act
    WikiPageBean actualWikiPageBean = new WikiPageBean();

    // Assert
    assertNull(actualWikiPageBean.content);
    assertNull(actualWikiPageBean.name);
    assertEquals(0L, actualWikiPageBean.parentId);
    assertEquals(0L, actualWikiPageBean.publishAt);
  }
}
