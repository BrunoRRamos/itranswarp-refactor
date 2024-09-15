package com.itranswarp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;

class I18NBuilderDiffblueTest {
  /**
   * Method under test: {@link I18NBuilder#extractKeys(String)}
   */
  @Test
  void testExtractKeys() {
    // Arrange and Act
    Set<String> actualExtractKeysResult = I18NBuilder.extractKeys("Line");

    // Assert
    assertTrue(actualExtractKeysResult.isEmpty());
  }

  /**
   * Method under test: {@link I18NBuilder#extractKeys(String)}
   */
  @Test
  void testExtractKeys2() {
    // Arrange and Act
    Set<String> actualExtractKeysResult = I18NBuilder.extractKeys("{{ _(\"U\") }}");

    // Assert
    assertEquals(1, actualExtractKeysResult.size());
    assertTrue(actualExtractKeysResult.contains("U"));
  }
}
