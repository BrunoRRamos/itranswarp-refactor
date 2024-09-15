package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SortBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link SortBean}
   */
  @Test
  void testNewSortBean() {
    // Arrange, Act and Assert
    assertNull((new SortBean()).ids);
  }

  /**
   * Method under test: {@link SortBean#validate(boolean)}
   */
  @Test
  void testValidate() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new SortBean()).validate(true));
  }

  /**
   * Method under test: {@link SortBean#validate(boolean)}
   */
  @Test
  void testValidate2() {
    // Arrange
    SortBean sortBean = new SortBean();
    sortBean.ids = new ArrayList<>();

    // Act and Assert
    assertThrows(ApiException.class, () -> sortBean.validate(true));
  }
}
