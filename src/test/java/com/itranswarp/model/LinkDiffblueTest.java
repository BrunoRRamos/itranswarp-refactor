package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class LinkDiffblueTest {
  /**
   * Method under test: {@link Link#getShortenUrl()}
   */
  @Test
  void testGetShortenUrl() {
    // Arrange, Act and Assert
    assertEquals("/link/0", (new Link()).getShortenUrl());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Link}
   */
  @Test
  void testNewLink() {
    // Arrange and Act
    Link actualLink = new Link();

    // Assert
    assertEquals("/link/0", actualLink.getShortenUrl());
    assertNull(actualLink.name);
    assertNull(actualLink.url);
    assertEquals(0L, actualLink.createdAt);
    assertEquals(0L, actualLink.id);
    assertEquals(0L, actualLink.updatedAt);
    assertEquals(0L, actualLink.version);
  }
}
