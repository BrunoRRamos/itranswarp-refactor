package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class WikiDiffblueTest {
  /**
   * Method under test: {@link Wiki#addChild(WikiPage)}
   */
  @Test
  void testAddChild() {
    // Arrange
    Wiki wiki = new Wiki();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(wikiPage3);

    // Act
    wiki.addChild(wikiPage4);

    // Assert
    List<WikiPage> children = wiki.getChildren();
    assertEquals(1, children.size());
    assertSame(wikiPage4, children.get(0));
  }

  /**
   * Method under test: {@link Wiki#addChild(WikiPage)}
   */
  @Test
  void testAddChild2() {
    // Arrange
    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(wikiPage3);

    Wiki wiki = new Wiki();
    wiki.addChild(wikiPage4);

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(new WikiPage());

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    WikiPage wikiPage8 = new WikiPage();
    wikiPage8.addChild(wikiPage7);

    // Act
    wiki.addChild(wikiPage8);

    // Assert
    List<WikiPage> children = wiki.getChildren();
    assertEquals(2, children.size());
    assertSame(wikiPage4, children.get(0));
    assertSame(wikiPage8, children.get(1));
  }

  /**
   * Method under test: {@link Wiki#getChildren()}
   */
  @Test
  void testGetChildren() {
    // Arrange, Act and Assert
    assertTrue((new Wiki()).getChildren().isEmpty());
  }

  /**
   * Method under test: {@link Wiki#getChildren()}
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

    Wiki wiki = new Wiki();
    wiki.addChild(wikiPage4);

    // Act
    List<WikiPage> actualChildren = wiki.getChildren();

    // Assert
    assertEquals(1, actualChildren.size());
    assertSame(wikiPage4, actualChildren.get(0));
  }

  /**
   * Method under test: default or parameterless constructor of {@link Wiki}
   */
  @Test
  void testNewWiki() {
    // Arrange and Act
    Wiki actualWiki = new Wiki();

    // Assert
    assertNull(actualWiki.description);
    assertNull(actualWiki.name);
    assertNull(actualWiki.tag);
    assertEquals(0L, actualWiki.createdAt);
    assertEquals(0L, actualWiki.id);
    assertEquals(0L, actualWiki.updatedAt);
    assertEquals(0L, actualWiki.version);
    assertEquals(0L, actualWiki.imageId);
    assertEquals(0L, actualWiki.publishAt);
    assertEquals(0L, actualWiki.textId);
    assertEquals(0L, actualWiki.userId);
    assertEquals(0L, actualWiki.views);
    assertTrue(actualWiki.getChildren().isEmpty());
  }
}
