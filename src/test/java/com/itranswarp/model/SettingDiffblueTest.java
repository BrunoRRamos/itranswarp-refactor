package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SettingDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Setting}
   */
  @Test
  void testNewSetting() {
    // Arrange and Act
    Setting actualSetting = new Setting();

    // Assert
    assertNull(actualSetting.settingGroup);
    assertNull(actualSetting.settingKey);
    assertNull(actualSetting.settingValue);
    assertEquals(0L, actualSetting.createdAt);
    assertEquals(0L, actualSetting.id);
    assertEquals(0L, actualSetting.updatedAt);
    assertEquals(0L, actualSetting.version);
  }
}
