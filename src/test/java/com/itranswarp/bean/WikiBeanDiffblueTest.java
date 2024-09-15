package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class WikiBeanDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link WikiBean}
   */
  @Test
  void testNewWikiBean() {
    // Arrange and Act
    WikiBean actualWikiBean = new WikiBean();

    // Assert
    assertNull(actualWikiBean.content);
    assertNull(actualWikiBean.description);
    assertNull(actualWikiBean.image);
    assertNull(actualWikiBean.name);
    assertNull(actualWikiBean.tag);
    assertEquals(0L, actualWikiBean.publishAt);
  }

  /**
   * Method under test: {@link WikiBean#validate(boolean)}
   */
  @Test
  void testValidate() {
    // Arrange
    WikiBean wikiBean = new WikiBean();
    wikiBean.description = "The characteristics of someone or something";
    wikiBean.name = "name";

    // Act
    wikiBean.validate(false);

    // Assert
    assertEquals("", wikiBean.tag);
  }
}
