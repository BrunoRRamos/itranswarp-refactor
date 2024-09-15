package com.itranswarp.web.view.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DefaultTranslatorDiffblueTest {
  /**
   * Method under test: {@link DefaultTranslator#getLocaleName()}
   */
  @Test
  void testGetLocaleName() {
    // Arrange, Act and Assert
    assertEquals("en", (new DefaultTranslator()).getLocaleName());
  }

  /**
   * Method under test: {@link DefaultTranslator#translate(String, Object[])}
   */
  @Test
  void testTranslate() {
    // Arrange, Act and Assert
    assertEquals("Text", (new DefaultTranslator()).translate("Text", "Args"));
    assertEquals("Text", (new DefaultTranslator()).translate("Text"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultTranslator}
   *   <li>{@link DefaultTranslator#getDisplayName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("English", (new DefaultTranslator()).getDisplayName());
  }
}
