package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ClassUtilDiffblueTest {
  /**
   * Method under test: {@link ClassUtil#getParameterizedType(Class)}
   */
  @Test
  void testGetParameterizedType() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.getParameterizedType(clazz));
  }

  /**
   * Method under test: {@link ClassUtil#getParameterizedType(Class, int)}
   */
  @Test
  void testGetParameterizedType2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClassUtil.getParameterizedType(clazz, 1));
  }
}
