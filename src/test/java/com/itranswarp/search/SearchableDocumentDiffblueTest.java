package com.itranswarp.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SearchableDocumentDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link SearchableDocument}
   */
  @Test
  void testNewSearchableDocument() {
    // Arrange and Act
    SearchableDocument actualSearchableDocument = new SearchableDocument();

    // Assert
    assertNull(actualSearchableDocument.content);
    assertNull(actualSearchableDocument.name);
    assertNull(actualSearchableDocument.type);
    assertNull(actualSearchableDocument.url);
    assertEquals(0L, actualSearchableDocument.id);
    assertEquals(0L, actualSearchableDocument.publishAt);
  }
}
