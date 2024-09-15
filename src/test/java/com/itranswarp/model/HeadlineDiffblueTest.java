package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class HeadlineDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Headline}
   */
  @Test
  void testNewHeadline() {
    // Arrange and Act
    Headline actualHeadline = new Headline();

    // Assert
    assertNull(actualHeadline.description);
    assertNull(actualHeadline.name);
    assertNull(actualHeadline.url);
    assertEquals(0L, actualHeadline.createdAt);
    assertEquals(0L, actualHeadline.id);
    assertEquals(0L, actualHeadline.updatedAt);
    assertEquals(0L, actualHeadline.version);
    assertEquals(0L, actualHeadline.publishAt);
    assertEquals(0L, actualHeadline.userId);
    assertFalse(actualHeadline.published);
  }
}
