package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class CategoryDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Category}
   */
  @Test
  void testNewCategory() {
    // Arrange and Act
    Category actualCategory = new Category();

    // Assert
    assertNull(actualCategory.description);
    assertNull(actualCategory.name);
    assertNull(actualCategory.tag);
    assertEquals(0L, actualCategory.createdAt);
    assertEquals(0L, actualCategory.id);
    assertEquals(0L, actualCategory.updatedAt);
    assertEquals(0L, actualCategory.version);
    assertEquals(0L, actualCategory.displayOrder);
  }
}
