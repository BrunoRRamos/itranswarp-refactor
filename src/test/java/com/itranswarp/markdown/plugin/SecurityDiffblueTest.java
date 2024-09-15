package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SecurityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Security}
   *   <li>{@link Security#getClosingDelimiter()}
   *   <li>{@link Security#getOpeningDelimiter()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Security actualSecurity = new Security();
    String actualClosingDelimiter = actualSecurity.getClosingDelimiter();

    // Assert
    assertEquals("$$", actualClosingDelimiter);
    assertEquals("$$", actualSecurity.getOpeningDelimiter());
    assertNull(actualSecurity.getFirstChild());
    assertNull(actualSecurity.getLastChild());
    assertNull(actualSecurity.getNext());
    assertNull(actualSecurity.getParent());
    assertNull(actualSecurity.getPrevious());
  }
}
