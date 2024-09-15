package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SinglePageDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link SinglePage}
   */
  @Test
  void testNewSinglePage() {
    // Arrange and Act
    SinglePage actualSinglePage = new SinglePage();

    // Assert
    assertNull(actualSinglePage.name);
    assertNull(actualSinglePage.tags);
    assertEquals(0L, actualSinglePage.createdAt);
    assertEquals(0L, actualSinglePage.id);
    assertEquals(0L, actualSinglePage.updatedAt);
    assertEquals(0L, actualSinglePage.version);
    assertEquals(0L, actualSinglePage.publishAt);
    assertEquals(0L, actualSinglePage.textId);
  }
}
