package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ClassPathUtilDiffblueTest {
  /**
   * Method under test: {@link ClassPathUtil#resolveBasePackage(String)}
   */
  @Test
  void testResolveBasePackage() {
    // Arrange, Act and Assert
    assertEquals("java/text", ClassPathUtil.resolveBasePackage("java.text"));
  }

  /**
   * Method under test: {@link ClassPathUtil#readFile(String)}
   */
  @Test
  void testReadFile() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> ClassPathUtil.readFile("Class Path File"));
  }
}
