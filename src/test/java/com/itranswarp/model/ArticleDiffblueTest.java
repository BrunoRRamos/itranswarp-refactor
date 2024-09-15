package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class ArticleDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Article}
   */
  @Test
  void testNewArticle() {
    // Arrange and Act
    Article actualArticle = new Article();

    // Assert
    assertNull(actualArticle.description);
    assertNull(actualArticle.name);
    assertNull(actualArticle.tags);
    assertEquals(0L, actualArticle.createdAt);
    assertEquals(0L, actualArticle.id);
    assertEquals(0L, actualArticle.updatedAt);
    assertEquals(0L, actualArticle.version);
    assertEquals(0L, actualArticle.categoryId);
    assertEquals(0L, actualArticle.imageId);
    assertEquals(0L, actualArticle.publishAt);
    assertEquals(0L, actualArticle.textId);
    assertEquals(0L, actualArticle.userId);
    assertEquals(0L, actualArticle.views);
  }
}
