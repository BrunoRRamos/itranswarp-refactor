package com.itranswarp.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class HitsDiffblueTest {
  /**
   * Method under test: {@link Hits#empty()}
   */
  @Test
  void testEmpty() {
    // Arrange and Act
    Hits actualEmptyResult = Hits.empty();

    // Assert
    assertEquals(0, actualEmptyResult.total);
    assertTrue(actualEmptyResult.documents.isEmpty());
  }

  /**
   * Method under test: {@link Hits#Hits(int, List)}
   */
  @Test
  void testNewHits() {
    // Arrange, Act and Assert
    assertTrue((new Hits(1, new ArrayList<>())).documents.isEmpty());
  }
}
