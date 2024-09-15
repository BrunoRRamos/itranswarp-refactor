package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AdPeriodDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link AdPeriod}
   */
  @Test
  void testNewAdPeriod() {
    // Arrange and Act
    AdPeriod actualAdPeriod = new AdPeriod();

    // Assert
    assertNull(actualAdPeriod.endAt);
    assertNull(actualAdPeriod.startAt);
    assertEquals(0L, actualAdPeriod.createdAt);
    assertEquals(0L, actualAdPeriod.id);
    assertEquals(0L, actualAdPeriod.updatedAt);
    assertEquals(0L, actualAdPeriod.version);
    assertEquals(0L, actualAdPeriod.adSlotId);
    assertEquals(0L, actualAdPeriod.displayOrder);
    assertEquals(0L, actualAdPeriod.userId);
  }
}
