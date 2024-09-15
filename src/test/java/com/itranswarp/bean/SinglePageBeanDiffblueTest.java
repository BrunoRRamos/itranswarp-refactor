package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SinglePageBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link SinglePageBean}
   */
  @Test
  void testNewSinglePageBean() {
    // Arrange and Act
    SinglePageBean actualSinglePageBean = new SinglePageBean();

    // Assert
    assertNull(actualSinglePageBean.content);
    assertNull(actualSinglePageBean.name);
    assertNull(actualSinglePageBean.tags);
    assertEquals(0L, actualSinglePageBean.publishAt);
  }

  /**
   * Method under test: {@link SinglePageBean#validate(boolean)}
   */
  @Test
  void testValidate() {
    // Arrange
    SinglePageBean singlePageBean = new SinglePageBean();
    singlePageBean.name = "name";

    // Act
    singlePageBean.validate(false);

    // Assert
    assertEquals("", singlePageBean.tags);
  }

  /**
   * Method under test: {@link SinglePageBean#validate(boolean)}
   */
  @Test
  void testValidate2() {
    // Arrange
    SinglePageBean singlePageBean = new SinglePageBean();
    singlePageBean.content = "Not all who wander are lost";
    singlePageBean.name = "name";

    // Act
    singlePageBean.validate(true);

    // Assert
    assertEquals("", singlePageBean.tags);
  }

  /**
   * Method under test: {@link SinglePageBean#validate(boolean)}
   */
  @Test
  void testValidate3() {
    // Arrange
    SinglePageBean singlePageBean = new SinglePageBean();
    singlePageBean.content = "Not all who wander are lost";
    singlePageBean.name = "name";

    // Act
    singlePageBean.validate(false);

    // Assert
    assertEquals("", singlePageBean.tags);
  }
}
