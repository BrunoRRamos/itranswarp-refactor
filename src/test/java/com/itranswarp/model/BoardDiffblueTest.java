package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BoardDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Board}
   */
  @Test
  void testNewBoard() {
    // Arrange and Act
    Board actualBoard = new Board();

    // Assert
    assertNull(actualBoard.description);
    assertNull(actualBoard.name);
    assertNull(actualBoard.tag);
    assertEquals(0L, actualBoard.createdAt);
    assertEquals(0L, actualBoard.id);
    assertEquals(0L, actualBoard.updatedAt);
    assertEquals(0L, actualBoard.version);
    assertEquals(0L, actualBoard.displayOrder);
    assertEquals(0L, actualBoard.topicNumber);
    assertFalse(actualBoard.locked);
  }
}
