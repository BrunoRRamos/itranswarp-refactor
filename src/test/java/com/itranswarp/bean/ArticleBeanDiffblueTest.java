package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ArticleBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ArticleBean}
   */
  @Test
  void testNewArticleBean() {
    // Arrange and Act
    ArticleBean actualArticleBean = new ArticleBean();

    // Assert
    assertNull(actualArticleBean.content);
    assertNull(actualArticleBean.description);
    assertNull(actualArticleBean.image);
    assertNull(actualArticleBean.name);
    assertNull(actualArticleBean.tags);
    assertEquals(0L, actualArticleBean.categoryId);
    assertEquals(0L, actualArticleBean.publishAt);
  }
}
