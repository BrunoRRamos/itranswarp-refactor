package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.bean.AdMaterialBean;
import com.itranswarp.common.ApiException;
import com.itranswarp.model.AdPeriod;
import com.itranswarp.model.User;
import org.junit.jupiter.api.Test;

class AdServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AdService#createAdMaterial(User, AdPeriod, AdMaterialBean)}
   */
  @Test
  void testCreateAdMaterial() {
    // Arrange
    AdService adService = new AdService();
    User user = new User();
    user.id = 1L;
    AdPeriod ap = new AdPeriod();

    // Act and Assert
    assertThrows(ApiException.class, () -> adService.createAdMaterial(user, ap, new AdMaterialBean()));
  }
}
