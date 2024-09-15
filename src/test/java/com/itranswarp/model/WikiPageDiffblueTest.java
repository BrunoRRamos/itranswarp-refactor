package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class WikiPageDiffblueTest {
  /**
   * Method under test: {@link WikiPage#getChildren()}
   */
  @Test
  void testGetChildren() {
    // Arrange, Act and Assert
    assertTrue((new WikiPage()).getChildren().isEmpty());
  }

  /**
   * Method under test: {@link WikiPage#getChildren()}
   */
  @Test
  void testGetChildren2() {
    // Arrange
    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(wikiPage3);

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    // Act
    List<WikiPage> actualChildren = wikiPage5.getChildren();

    // Assert
    assertEquals(1, actualChildren.size());
    assertSame(wikiPage4, actualChildren.get(0));
  }

  /**
   * Method under test: default or parameterless constructor of {@link WikiPage}
   */
  @Test
  void testNewWikiPage() {
    // Arrange and Act
    WikiPage actualWikiPage = new WikiPage();

    // Assert
    assertNull(actualWikiPage.name);
    assertEquals(0L, actualWikiPage.createdAt);
    assertEquals(0L, actualWikiPage.id);
    assertEquals(0L, actualWikiPage.updatedAt);
    assertEquals(0L, actualWikiPage.version);
    assertEquals(0L, actualWikiPage.displayOrder);
    assertEquals(0L, actualWikiPage.parentId);
    assertEquals(0L, actualWikiPage.publishAt);
    assertEquals(0L, actualWikiPage.textId);
    assertEquals(0L, actualWikiPage.views);
    assertEquals(0L, actualWikiPage.wikiId);
    assertTrue(actualWikiPage.getChildren().isEmpty());
  }
}
