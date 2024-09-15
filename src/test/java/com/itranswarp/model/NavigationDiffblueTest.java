package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class NavigationDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Navigation}
   */
  @Test
  void testNewNavigation() {
    // Arrange and Act
    Navigation actualNavigation = new Navigation();

    // Assert
    assertNull(actualNavigation.icon);
    assertNull(actualNavigation.name);
    assertNull(actualNavigation.url);
    assertEquals(0L, actualNavigation.createdAt);
    assertEquals(0L, actualNavigation.id);
    assertEquals(0L, actualNavigation.updatedAt);
    assertEquals(0L, actualNavigation.version);
    assertEquals(0L, actualNavigation.displayOrder);
    assertFalse(actualNavigation.blank);
  }
}
