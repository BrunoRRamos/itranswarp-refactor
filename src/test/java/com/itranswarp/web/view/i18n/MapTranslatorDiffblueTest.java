package com.itranswarp.web.view.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MapTranslatorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapTranslator#getDisplayName()}
   *   <li>{@link MapTranslator#getLocaleName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MapTranslator mapTranslator = new MapTranslator("en", "Display Name", new HashMap<>());

    // Act
    String actualDisplayName = mapTranslator.getDisplayName();

    // Assert
    assertEquals("Display Name", actualDisplayName);
    assertEquals("en", mapTranslator.getLocaleName());
  }

  /**
   * Method under test: {@link MapTranslator#translate(String, Object[])}
   */
  @Test
  void testTranslate() {
    // Arrange, Act and Assert
    assertEquals("Text", (new MapTranslator("en", "Display Name", new HashMap<>())).translate("Text", "Args"));
    assertEquals("Text", (new MapTranslator("en", "Display Name", new HashMap<>())).translate("Text"));
  }

  /**
   * Method under test: {@link MapTranslator#MapTranslator(String, String, Map)}
   */
  @Test
  void testNewMapTranslator() {
    // Arrange and Act
    MapTranslator actualMapTranslator = new MapTranslator("en", "Display Name", new HashMap<>());

    // Assert
    assertEquals("Display Name", actualMapTranslator.getDisplayName());
    assertEquals("en", actualMapTranslator.getLocaleName());
    assertTrue(actualMapTranslator.translator.isEmpty());
  }
}
