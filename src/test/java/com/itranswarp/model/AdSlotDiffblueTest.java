package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AdSlotDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link AdSlot}
   */
  @Test
  void testNewAdSlot() {
    // Arrange and Act
    AdSlot actualAdSlot = new AdSlot();

    // Assert
    assertNull(actualAdSlot.adAutoFill);
    assertNull(actualAdSlot.alias);
    assertNull(actualAdSlot.description);
    assertNull(actualAdSlot.name);
    assertEquals(0L, actualAdSlot.createdAt);
    assertEquals(0L, actualAdSlot.id);
    assertEquals(0L, actualAdSlot.updatedAt);
    assertEquals(0L, actualAdSlot.version);
    assertEquals(0L, actualAdSlot.height);
    assertEquals(0L, actualAdSlot.numAutoFill);
    assertEquals(0L, actualAdSlot.numSlots);
    assertEquals(0L, actualAdSlot.price);
    assertEquals(0L, actualAdSlot.width);
  }
}
