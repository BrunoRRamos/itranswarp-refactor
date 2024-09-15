package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.common.ApiException;
import com.itranswarp.model.Article;
import com.itranswarp.model.SinglePage;
import com.itranswarp.model.Wiki;
import com.itranswarp.model.WikiPage;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class ApiControllerDiffblueTest {
  /**
   * Method under test:
   * {@link ApiController.ArticleWithContent#ArticleWithContent(Article, String)}
   */
  @Test
  void testArticleWithContentNewArticleWithContent() {
    // Arrange and Act
    ApiController.ArticleWithContent actualArticleWithContent = new ApiController.ArticleWithContent(new Article(),
        "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualArticleWithContent.content);
    assertNull(actualArticleWithContent.description);
    assertNull(actualArticleWithContent.name);
    assertNull(actualArticleWithContent.tags);
    assertEquals(0L, actualArticleWithContent.createdAt);
    assertEquals(0L, actualArticleWithContent.id);
    assertEquals(0L, actualArticleWithContent.updatedAt);
    assertEquals(0L, actualArticleWithContent.version);
    assertEquals(0L, actualArticleWithContent.categoryId);
    assertEquals(0L, actualArticleWithContent.imageId);
    assertEquals(0L, actualArticleWithContent.publishAt);
    assertEquals(0L, actualArticleWithContent.textId);
    assertEquals(0L, actualArticleWithContent.userId);
    assertEquals(0L, actualArticleWithContent.views);
  }

  /**
   * Method under test:
   * {@link ApiController.NavigationMenu#NavigationMenu(String, String)}
   */
  @Test
  void testNavigationMenuNewNavigationMenu() {
    // Arrange and Act
    ApiController.NavigationMenu actualNavigationMenu = new ApiController.NavigationMenu("Name",
        "https://example.org/example");

    // Assert
    assertEquals("Name", actualNavigationMenu.name);
    assertEquals("https://example.org/example", actualNavigationMenu.url);
  }

  /**
   * Method under test:
   * {@link ApiController.SinglePageWithContent#SinglePageWithContent(SinglePage, String)}
   */
  @Test
  void testSinglePageWithContentNewSinglePageWithContent() {
    // Arrange and Act
    ApiController.SinglePageWithContent actualSinglePageWithContent = new ApiController.SinglePageWithContent(
        new SinglePage(), "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualSinglePageWithContent.content);
    assertNull(actualSinglePageWithContent.name);
    assertNull(actualSinglePageWithContent.tags);
    assertEquals(0L, actualSinglePageWithContent.createdAt);
    assertEquals(0L, actualSinglePageWithContent.id);
    assertEquals(0L, actualSinglePageWithContent.updatedAt);
    assertEquals(0L, actualSinglePageWithContent.version);
    assertEquals(0L, actualSinglePageWithContent.publishAt);
    assertEquals(0L, actualSinglePageWithContent.textId);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ApiController.UpdatePasswordBean}
   */
  @Test
  void testUpdatePasswordBeanNewUpdatePasswordBean() {
    // Arrange, Act and Assert
    assertNull((new ApiController.UpdatePasswordBean()).password);
  }

  /**
   * Method under test: {@link ApiController#usersByIds(HttpServletRequest)}
   */
  @Test
  void testUsersByIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiController apiController = new ApiController();

    // Act and Assert
    assertTrue(apiController.usersByIds(new MockHttpServletRequest()).isEmpty());
  }

  /**
   * Method under test: {@link ApiController#userUpdateLock(long, long)}
   */
  @Test
  void testUserUpdateLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new ApiController()).userUpdateLock(1L, -1L));
  }

  /**
   * Method under test:
   * {@link ApiController.WikiPageWithContent#WikiPageWithContent(WikiPage, String)}
   */
  @Test
  void testWikiPageWithContentNewWikiPageWithContent() {
    // Arrange
    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    WikiPage wikiPage4 = new WikiPage();
    wikiPage4.addChild(wikiPage3);

    // Act
    ApiController.WikiPageWithContent actualWikiPageWithContent = new ApiController.WikiPageWithContent(wikiPage4,
        "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualWikiPageWithContent.content);
    assertNull(actualWikiPageWithContent.name);
    assertEquals(0L, actualWikiPageWithContent.createdAt);
    assertEquals(0L, actualWikiPageWithContent.id);
    assertEquals(0L, actualWikiPageWithContent.updatedAt);
    assertEquals(0L, actualWikiPageWithContent.version);
    assertEquals(0L, actualWikiPageWithContent.displayOrder);
    assertEquals(0L, actualWikiPageWithContent.parentId);
    assertEquals(0L, actualWikiPageWithContent.publishAt);
    assertEquals(0L, actualWikiPageWithContent.textId);
    assertEquals(0L, actualWikiPageWithContent.views);
    assertEquals(0L, actualWikiPageWithContent.wikiId);
    assertTrue(actualWikiPageWithContent.getChildren().isEmpty());
  }

  /**
   * Method under test:
   * {@link ApiController.WikiWithContent#WikiWithContent(Wiki, String)}
   */
  @Test
  void testWikiWithContentNewWikiWithContent() {
    // Arrange
    WikiPage wikiPage = new WikiPage();
    wikiPage.addChild(new WikiPage());

    WikiPage wikiPage2 = new WikiPage();
    wikiPage2.addChild(wikiPage);

    WikiPage wikiPage3 = new WikiPage();
    wikiPage3.addChild(wikiPage2);

    Wiki wiki = new Wiki();
    wiki.addChild(wikiPage3);

    // Act
    ApiController.WikiWithContent actualWikiWithContent = new ApiController.WikiWithContent(wiki,
        "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualWikiWithContent.content);
    assertNull(actualWikiWithContent.description);
    assertNull(actualWikiWithContent.name);
    assertNull(actualWikiWithContent.tag);
    assertEquals(0L, actualWikiWithContent.createdAt);
    assertEquals(0L, actualWikiWithContent.id);
    assertEquals(0L, actualWikiWithContent.updatedAt);
    assertEquals(0L, actualWikiWithContent.version);
    assertEquals(0L, actualWikiWithContent.imageId);
    assertEquals(0L, actualWikiWithContent.publishAt);
    assertEquals(0L, actualWikiWithContent.textId);
    assertEquals(0L, actualWikiWithContent.userId);
    assertEquals(0L, actualWikiWithContent.views);
    assertTrue(actualWikiWithContent.getChildren().isEmpty());
  }
}
