package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.model.AdSlot;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AdInfoDiffblueTest {
  /**
   * Method under test: {@link AdInfo.AdMaterialInfo#AdMaterialInfo()}
   */
  @Test
  void testAdMaterialInfoNewAdMaterialInfo() {
    // Arrange and Act
    AdInfo.AdMaterialInfo actualAdMaterialInfo = new AdInfo.AdMaterialInfo();

    // Assert
    assertNull(actualAdMaterialInfo.tags);
    assertNull(actualAdMaterialInfo.url);
    assertEquals(0L, actualAdMaterialInfo.imageId);
    assertEquals(0L, actualAdMaterialInfo.weight);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AdInfo.AdPeriodInfo}
   */
  @Test
  void testAdPeriodInfoNewAdPeriodInfo() {
    // Arrange, Act and Assert
    assertTrue((new AdInfo.AdPeriodInfo()).materials.isEmpty());
  }

  /**
   * Method under test: {@link AdInfo.AdSlotInfo#addAdPeriodWithAdMaterials(List)}
   */
  @Test
  void testAdSlotInfoAddAdPeriodWithAdMaterials() {
    // Arrange
    AdInfo.AdSlotInfo adSlotInfo = new AdInfo.AdSlotInfo();

    // Act
    adSlotInfo.addAdPeriodWithAdMaterials(new ArrayList<>());

    // Assert
    List<AdInfo.AdPeriodInfo> adPeriodInfoList = adSlotInfo.periods;
    assertEquals(1, adPeriodInfoList.size());
    assertTrue(adPeriodInfoList.get(0).materials.isEmpty());
  }

  /**
   * Method under test: {@link AdInfo.AdSlotInfo#AdSlotInfo()}
   */
  @Test
  void testAdSlotInfoNewAdSlotInfo() {
    // Arrange, Act and Assert
    assertTrue((new AdInfo.AdSlotInfo()).periods.isEmpty());
  }

  /**
   * Method under test: {@link AdInfo.AdSlotInfo#AdSlotInfo(AdSlot)}
   */
  @Test
  void testAdSlotInfoNewAdSlotInfo2() {
    // Arrange and Act
    AdInfo.AdSlotInfo actualAdSlotInfo = new AdInfo.AdSlotInfo(new AdSlot());

    // Assert
    assertNull(actualAdSlotInfo.adAutoFill);
    assertNull(actualAdSlotInfo.alias);
    assertEquals(0L, actualAdSlotInfo.height);
    assertEquals(0L, actualAdSlotInfo.numAutoFill);
    assertEquals(0L, actualAdSlotInfo.numSlots);
    assertEquals(0L, actualAdSlotInfo.width);
    assertTrue(actualAdSlotInfo.periods.isEmpty());
  }

  /**
   * Method under test: {@link AdInfo#addAdSlot(AdSlot)}
   */
  @Test
  void testAddAdSlot() {
    // Arrange
    AdInfo adInfo = new AdInfo();

    // Act
    AdInfo.AdSlotInfo actualAddAdSlotResult = adInfo.addAdSlot(new AdSlot());

    // Assert
    assertNull(actualAddAdSlotResult.adAutoFill);
    assertNull(actualAddAdSlotResult.alias);
    assertEquals(0L, actualAddAdSlotResult.height);
    assertEquals(0L, actualAddAdSlotResult.numAutoFill);
    assertEquals(0L, actualAddAdSlotResult.numSlots);
    assertEquals(0L, actualAddAdSlotResult.width);
    assertEquals(1, adInfo.slots.size());
    assertTrue(actualAddAdSlotResult.periods.isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of {@link AdInfo}
   */
  @Test
  void testNewAdInfo() {
    // Arrange, Act and Assert
    assertTrue((new AdInfo()).slots.isEmpty());
  }
}
