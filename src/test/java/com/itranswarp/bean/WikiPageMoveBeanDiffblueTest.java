package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class WikiPageMoveBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link WikiPageMoveBean}
   */
  @Test
  void testNewWikiPageMoveBean() {
    // Arrange and Act
    WikiPageMoveBean actualWikiPageMoveBean = new WikiPageMoveBean();

    // Assert
    assertEquals(0, actualWikiPageMoveBean.displayIndex);
    assertEquals(0L, actualWikiPageMoveBean.parentId);
  }
}
