package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.api.Test;

class AdMaterialBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link AdMaterialBean}
   */
  @Test
  void testNewAdMaterialBean() {
    // Arrange and Act
    AdMaterialBean actualAdMaterialBean = new AdMaterialBean();

    // Assert
    assertNull(actualAdMaterialBean.endAt);
    assertNull(actualAdMaterialBean.geo);
    assertNull(actualAdMaterialBean.image);
    assertNull(actualAdMaterialBean.startAt);
    assertNull(actualAdMaterialBean.tags);
    assertNull(actualAdMaterialBean.url);
    assertEquals(0L, actualAdMaterialBean.weight);
  }

  /**
   * Method under test: {@link AdMaterialBean#validate(boolean)}
   */
  @Test
  void testValidate() {
    // Arrange
    AdMaterialBean adMaterialBean = new AdMaterialBean();
    adMaterialBean.geo = null;
    adMaterialBean.endAt = "1970-01-01";
    adMaterialBean.startAt = null;

    // Act and Assert
    assertThrows(ApiException.class, () -> adMaterialBean.validate(false));
  }
}
