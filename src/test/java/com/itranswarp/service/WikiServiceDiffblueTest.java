package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.model.Wiki;
import com.itranswarp.model.WikiPage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WikiServiceDiffblueTest {
  /**
   * Method under test: {@link WikiService#treeIterate(Wiki, Map)}
   */
  @Test
  void testTreeIterate() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    Wiki root = new Wiki();
    root.addChild(wikiPage3);
    HashMap<Long, WikiPage> nodes = new HashMap<>();

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert that nothing has changed
    assertEquals(1, root.getChildren().size());
    assertTrue(nodes.isEmpty());
  }

  /**
   * Method under test: {@link WikiService#treeIterate(Wiki, Map)}
   */
  @Test
  void testTreeIterate2() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(new WikiPage());

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    Wiki root = new Wiki();
    root.addChild(wikiPage7);
    root.addChild(wikiPage3);
    HashMap<Long, WikiPage> nodes = new HashMap<>();

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert that nothing has changed
    List<WikiPage> children = root.getChildren();
    assertEquals(2, children.size());
    assertTrue(nodes.isEmpty());
    assertSame(wikiPage3, children.get(1));
  }

  /**
   * Method under test: {@link WikiService#treeIterate(Wiki, Map)}
   */
  @Test
  void testTreeIterate3() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(new WikiPage());

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(wikiPage3);

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);
    wikiPage7.addChild(wikiPage2);

    Wiki root = new Wiki();
    root.addChild(wikiPage7);
    HashMap<Long, WikiPage> nodes = new HashMap<>();

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert that nothing has changed
    assertEquals(1, root.getChildren().size());
    assertTrue(nodes.isEmpty());
  }

  /**
   * Method under test: {@link WikiService#treeIterate(Wiki, Map)}
   */
  @Test
  void testTreeIterate4() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    Wiki root = new Wiki();
    root.addChild(wikiPage3);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(new WikiPage());

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    HashMap<Long, WikiPage> nodes = new HashMap<>();
    nodes.put(1L, wikiPage7);

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert
    List<WikiPage> children = root.getChildren();
    assertEquals(2, children.size());
    assertTrue(nodes.isEmpty());
    assertSame(wikiPage7, children.get(1));
  }

  /**
   * Method under test: {@link WikiService#treeIterate(Wiki, Map)}
   */
  @Test
  void testTreeIterate5() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    Wiki root = new Wiki();
    root.addChild(wikiPage3);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(new WikiPage());

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    WikiPage wikiPage8 = new WikiPage();
    wikiPage8.addChild(new WikiPage());

    WikiPage wikiPage9 = new WikiPage();
    wikiPage9.addChild(wikiPage8);

    WikiPage wikiPage10 = new WikiPage();
    wikiPage10.addChild(wikiPage9);

    WikiPage wikiPage11 = new WikiPage();
    wikiPage11.addChild(wikiPage10);

    HashMap<Long, WikiPage> nodes = new HashMap<>();
    nodes.put(0L, wikiPage11);
    nodes.put(1L, wikiPage7);

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert
    List<WikiPage> children = root.getChildren();
    assertEquals(3, children.size());
    assertTrue(nodes.isEmpty());
    assertSame(wikiPage11, children.get(1));
    assertSame(wikiPage7, children.get(2));
  }

  /**
   * Method under test: {@link WikiService#treeIterate(WikiPage, Map)}
   */
  @Test
  void testTreeIterate6() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage root = new WikiPage();
    root.addChild(wikiPage3);
    HashMap<Long, WikiPage> nodes = new HashMap<>();

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert that nothing has changed
    assertEquals(1, root.getChildren().size());
    assertTrue(nodes.isEmpty());
  }

  /**
   * Method under test: {@link WikiService#treeIterate(WikiPage, Map)}
   */
  @Test
  void testTreeIterate7() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(new WikiPage());

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    WikiPage root = new WikiPage();
    root.addChild(wikiPage7);
    root.addChild(wikiPage3);
    HashMap<Long, WikiPage> nodes = new HashMap<>();

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert that nothing has changed
    List<WikiPage> children = root.getChildren();
    assertEquals(2, children.size());
    assertTrue(nodes.isEmpty());
    assertSame(wikiPage3, children.get(1));
  }

  /**
   * Method under test: {@link WikiService#treeIterate(WikiPage, Map)}
   */
  @Test
  void testTreeIterate8() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage root = new WikiPage();
    root.addChild(wikiPage3);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(new WikiPage());

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    HashMap<Long, WikiPage> nodes = new HashMap<>();
    nodes.put(1L, wikiPage7);

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert
    List<WikiPage> children = root.getChildren();
    assertEquals(2, children.size());
    assertTrue(nodes.isEmpty());
    assertSame(wikiPage7, children.get(1));
  }

  /**
   * Method under test: {@link WikiService#treeIterate(WikiPage, Map)}
   */
  @Test
  void testTreeIterate9() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage root = new WikiPage();
    root.addChild(wikiPage3);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(new WikiPage());

    WikiPage wikiPage5 = new WikiPage();
    wikiPage5.addChild(wikiPage4);

    WikiPage wikiPage6 = new WikiPage();
    wikiPage6.addChild(wikiPage5);

    WikiPage wikiPage7 = new WikiPage();
    wikiPage7.addChild(wikiPage6);

    WikiPage wikiPage8 = new WikiPage();
    wikiPage8.addChild(new WikiPage());

    WikiPage wikiPage9 = new WikiPage();
    wikiPage9.addChild(wikiPage8);

    WikiPage wikiPage10 = new WikiPage();
    wikiPage10.addChild(wikiPage9);

    WikiPage wikiPage11 = new WikiPage();
    wikiPage11.addChild(wikiPage10);

    HashMap<Long, WikiPage> nodes = new HashMap<>();
    nodes.put(0L, wikiPage11);
    nodes.put(1L, wikiPage7);

    // Act
    wikiService.treeIterate(root, nodes);

    // Assert
    List<WikiPage> children = root.getChildren();
    assertEquals(3, children.size());
    assertTrue(nodes.isEmpty());
    assertSame(wikiPage11, children.get(1));
    assertSame(wikiPage7, children.get(2));
  }

  /**
   * Method under test: {@link WikiService#getLeafToRootIds(Wiki, long)}
   */
  @Test
  void testGetLeafToRootIds() {
    // Arrange
    WikiService wikiService = new WikiService();

    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    Wiki wiki = new Wiki();
    wiki.addChild(wikiPage3);

    // Act
    List<Long> actualLeafToRootIds = wikiService.getLeafToRootIds(wiki, 0L);

    // Assert
    assertEquals(1, actualLeafToRootIds.size());
    assertEquals(0L, actualLeafToRootIds.get(0).longValue());
  }
}
