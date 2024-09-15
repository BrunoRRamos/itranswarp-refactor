package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;
import org.junit.jupiter.api.Test;

class SecurityDelimiterProcessorDiffblueTest {
  /**
   * Method under test: {@link SecurityDelimiterProcessor#getClosingCharacter()}
   */
  @Test
  void testGetClosingCharacter() {
    // Arrange, Act and Assert
    assertEquals('$', (new SecurityDelimiterProcessor()).getClosingCharacter());
  }

  /**
   * Method under test:
   * {@link SecurityDelimiterProcessor#getDelimiterUse(DelimiterRun, DelimiterRun)}
   */
  @Test
  void testGetDelimiterUse() {
    // Arrange
    SecurityDelimiterProcessor securityDelimiterProcessor = new SecurityDelimiterProcessor();
    Delimiter opener = new Delimiter(new Text("Literal"), 'A', true, true, null);

    // Act and Assert
    assertEquals(0,
        securityDelimiterProcessor.getDelimiterUse(opener, new Delimiter(new Text("Literal"), 'A', true, true, null)));
  }

  /**
   * Method under test: {@link SecurityDelimiterProcessor#getOpeningCharacter()}
   */
  @Test
  void testGetOpeningCharacter() {
    // Arrange, Act and Assert
    assertEquals('$', (new SecurityDelimiterProcessor()).getOpeningCharacter());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SecurityDelimiterProcessor}
   *   <li>{@link SecurityDelimiterProcessor#getMinLength()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(2, (new SecurityDelimiterProcessor()).getMinLength());
  }
}
