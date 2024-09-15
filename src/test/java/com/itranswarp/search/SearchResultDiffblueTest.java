package com.itranswarp.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SearchResultDiffblueTest {
  /**
   * Method under test:
   * {@link SearchResult#SearchResult(String, String, String, String)}
   */
  @Test
  void testNewSearchResult() {
    // Arrange and Act
    SearchResult actualSearchResult = new SearchResult("Name", "Type", "https://example.org/example",
        "Not all who wander are lost");

    // Assert
    assertEquals("Name", actualSearchResult.name);
    assertEquals("Not all who wander are lost", actualSearchResult.content);
    assertEquals("Type", actualSearchResult.type);
    assertEquals("https://example.org/example", actualSearchResult.url);
  }
}
