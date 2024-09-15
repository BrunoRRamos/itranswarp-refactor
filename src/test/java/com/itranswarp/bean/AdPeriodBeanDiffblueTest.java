package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AdPeriodBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link AdPeriodBean}
   */
  @Test
  void testNewAdPeriodBean() {
    // Arrange and Act
    AdPeriodBean actualAdPeriodBean = new AdPeriodBean();

    // Assert
    assertNull(actualAdPeriodBean.endAt);
    assertNull(actualAdPeriodBean.startAt);
    assertEquals(0L, actualAdPeriodBean.adSlotId);
    assertEquals(0L, actualAdPeriodBean.userId);
  }
}
