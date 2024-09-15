package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AdSlotBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link AdSlotBean}
   */
  @Test
  void testNewAdSlotBean() {
    // Arrange and Act
    AdSlotBean actualAdSlotBean = new AdSlotBean();

    // Assert
    assertNull(actualAdSlotBean.adAutoFill);
    assertNull(actualAdSlotBean.alias);
    assertNull(actualAdSlotBean.description);
    assertNull(actualAdSlotBean.name);
    assertEquals(0L, actualAdSlotBean.height);
    assertEquals(0L, actualAdSlotBean.numAutoFill);
    assertEquals(0L, actualAdSlotBean.numSlots);
    assertEquals(0L, actualAdSlotBean.price);
    assertEquals(0L, actualAdSlotBean.width);
  }
}
