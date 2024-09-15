package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class NavigationBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link NavigationBean}
   */
  @Test
  void testNewNavigationBean() {
    // Arrange and Act
    NavigationBean actualNavigationBean = new NavigationBean();

    // Assert
    assertNull(actualNavigationBean.icon);
    assertNull(actualNavigationBean.name);
    assertNull(actualNavigationBean.url);
    assertFalse(actualNavigationBean.blank);
  }
}
