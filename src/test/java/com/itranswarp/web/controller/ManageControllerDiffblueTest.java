package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.api.Test;

class ManageControllerDiffblueTest {
  /**
   * Method under test: {@link ManageController#index()}
   */
  @Test
  void testIndex() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/manage/board/", (new ManageController()).index());
  }

  /**
   * Method under test: {@link ManageController#setting()}
   */
  @Test
  void testSetting() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/manage/setting/website", (new ManageController()).setting());
    assertThrows(ApiException.class, () -> (new ManageController()).setting("Group"));
  }
}
