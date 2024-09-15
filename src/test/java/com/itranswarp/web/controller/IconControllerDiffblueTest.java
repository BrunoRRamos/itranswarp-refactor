package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class IconControllerDiffblueTest {
  /**
   * Method under test: {@link IconController#init()}
   */
  @Test
  void testInit() {
    // Arrange
    IconController iconController = new IconController();

    // Act
    iconController.init();

    // Assert
    assertEquals("public, max-age=31536000", iconController.maxAge);
  }

  /**
   * Method under test: {@link IconController#svgAvatar(int)}
   */
  @Test
  void testSvgAvatar() {
    // Arrange, Act and Assert
    assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-1.5 -1.5 8 8\" fill=\"hsl(310 50% 50%)\">\n"
        + "<rect x=\"0\" y=\"0\" width=\"1\" height=\"1\"/>\n" + "<rect x=\"4\" y=\"0\" width=\"1\" height=\"1\"/>\n"
        + "<rect x=\"0\" y=\"2\" width=\"1\" height=\"1\"/>\n" + "<rect x=\"4\" y=\"2\" width=\"1\" height=\"1\"/>\n"
        + "<rect x=\"1\" y=\"0\" width=\"1\" height=\"1\"/>\n" + "<rect x=\"3\" y=\"0\" width=\"1\" height=\"1\"/>\n"
        + "<rect x=\"1\" y=\"3\" width=\"1\" height=\"1\"/>\n" + "<rect x=\"3\" y=\"3\" width=\"1\" height=\"1\"/>\n"
        + "<rect x=\"2\" y=\"0\" width=\"1\" height=\"1\"/>\n" + "<rect x=\"2\" y=\"1\" width=\"1\" height=\"1\"/>\n"
        + "<rect x=\"2\" y=\"2\" width=\"1\" height=\"1\"/>\n" + "<rect x=\"2\" y=\"4\" width=\"1\" height=\"1\"/>\n"
        + "</svg>", (new IconController()).svgAvatar(19088743));
  }

  /**
   * Method under test: {@link IconController#append(StringBuilder, int, int)}
   */
  @Test
  void testAppend() {
    // Arrange
    IconController iconController = new IconController();
    StringBuilder sb = new StringBuilder("foo");

    // Act
    iconController.append(sb, 2, 3);

    // Assert
    assertEquals("foo<rect x=\"2\" y=\"3\" width=\"1\" height=\"1\"/>\n", sb.toString());
  }
}
