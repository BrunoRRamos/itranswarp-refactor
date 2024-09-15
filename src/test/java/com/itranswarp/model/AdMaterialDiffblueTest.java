package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AdMaterialDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link AdMaterial}
   */
  @Test
  void testNewAdMaterial() {
    // Arrange and Act
    AdMaterial actualAdMaterial = new AdMaterial();

    // Assert
    assertNull(actualAdMaterial.endAt);
    assertNull(actualAdMaterial.geo);
    assertNull(actualAdMaterial.startAt);
    assertNull(actualAdMaterial.tags);
    assertNull(actualAdMaterial.url);
    assertEquals(0L, actualAdMaterial.createdAt);
    assertEquals(0L, actualAdMaterial.id);
    assertEquals(0L, actualAdMaterial.updatedAt);
    assertEquals(0L, actualAdMaterial.version);
    assertEquals(0L, actualAdMaterial.adPeriodId);
    assertEquals(0L, actualAdMaterial.imageId);
    assertEquals(0L, actualAdMaterial.weight);
  }
}
