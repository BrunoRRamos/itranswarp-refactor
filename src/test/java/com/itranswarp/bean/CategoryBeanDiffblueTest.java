package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class CategoryBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link CategoryBean}
   */
  @Test
  void testNewCategoryBean() {
    // Arrange and Act
    CategoryBean actualCategoryBean = new CategoryBean();

    // Assert
    assertNull(actualCategoryBean.description);
    assertNull(actualCategoryBean.name);
    assertNull(actualCategoryBean.tag);
  }

  /**
   * Method under test: {@link CategoryBean#validate(boolean)}
   */
  @Test
  void testValidate() {
    // Arrange
    CategoryBean categoryBean = new CategoryBean();
    categoryBean.description = "The characteristics of someone or something";
    categoryBean.name = "name";

    // Act
    categoryBean.validate(true);

    // Assert
    assertEquals("", categoryBean.tag);
  }
}
