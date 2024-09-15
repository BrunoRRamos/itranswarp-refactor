package com.itranswarp.markdown;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.junit.jupiter.api.Test;

class AltTextVisitorDiffblueTest {
  /**
   * Method under test: {@link AltTextVisitor#getAltText()}
   */
  @Test
  void testGetAltText() {
    // Arrange, Act and Assert
    assertEquals("", (new AltTextVisitor()).getAltText());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AltTextVisitor}
   */
  @Test
  void testNewAltTextVisitor() {
    // Arrange, Act and Assert
    assertEquals("", (new AltTextVisitor()).getAltText());
  }

  /**
   * Method under test: {@link AltTextVisitor#visit(HardLineBreak)}
   */
  @Test
  void testVisit() {
    // Arrange
    AltTextVisitor altTextVisitor = new AltTextVisitor();

    // Act
    altTextVisitor.visit(new HardLineBreak());

    // Assert
    assertEquals("\n", altTextVisitor.getAltText());
  }

  /**
   * Method under test: {@link AltTextVisitor#visit(SoftLineBreak)}
   */
  @Test
  void testVisit2() {
    // Arrange
    AltTextVisitor altTextVisitor = new AltTextVisitor();

    // Act
    altTextVisitor.visit(new SoftLineBreak());

    // Assert
    assertEquals("\n", altTextVisitor.getAltText());
  }

  /**
   * Method under test: {@link AltTextVisitor#visit(Text)}
   */
  @Test
  void testVisit3() {
    // Arrange
    AltTextVisitor altTextVisitor = new AltTextVisitor();

    // Act
    altTextVisitor.visit(new Text("Literal"));

    // Assert
    assertEquals("Literal", altTextVisitor.getAltText());
  }
}
