package com.itranswarp.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.api.Test;

class AbstractRequestBeanDiffblueTest {
  /**
   * Method under test: {@link AbstractRequestBean#checkPassword(String)}
   */
  @Test
  void testCheckPassword() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkPassword("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkPassword(null));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkId(String, long)}
   */
  @Test
  void testCheckId() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkId("Name", 0L));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkTimestamp(String, long)}
   */
  @Test
  void testCheckTimestamp() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkTimestamp("Name", -1L));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkLocalDate(String, String)}
   */
  @Test
  void testCheckLocalDate() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkLocalDate("Name", "42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkLocalDate("Name", null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkLocalDate("Name", ""));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkName(String)}
   */
  @Test
  void testCheckName() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkName("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkName(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkName(""));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkIcon(String)}
   */
  @Test
  void testCheckIcon() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkIcon("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkIcon(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkIcon(""));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkDescription(String)}
   */
  @Test
  void testCheckDescription() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkDescription("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkDescription(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkDescription(""));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkContent(String)}
   */
  @Test
  void testCheckContent() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkContent("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkContent(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkContent(""));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkImage(String)}
   */
  @Test
  void testCheckImage() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkImage("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkImage(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkImage(""));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkAlias(String)}
   */
  @Test
  void testCheckAlias() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkAlias("42"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkAlias(null));
    assertEquals("lll", (new AdMaterialBean()).checkAlias("lll"));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkTag(String)}
   */
  @Test
  void testCheckTag() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkTag("42"));
    assertEquals("", (new AdMaterialBean()).checkTag(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkTag("^[^\\,\\;]{1,32}$"));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkTags(String)}
   */
  @Test
  void testCheckTags() {
    // Arrange, Act and Assert
    assertEquals("42", (new AdMaterialBean()).checkTags("42"));
    assertEquals("", (new AdMaterialBean()).checkTags(null));
    assertEquals("", (new AdMaterialBean()).checkTags(" "));
    assertEquals("\\s?[\\,\\,]+\\s?", (new AdMaterialBean()).checkTags("\\s?[\\,\\;]+\\s?"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkTags(","));
  }

  /**
   * Method under test: {@link AbstractRequestBean#checkUrl(String)}
   */
  @Test
  void testCheckUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", (new AdMaterialBean()).checkUrl("https://example.org/example"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl(null));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl("url"));
    assertEquals("/", (new AdMaterialBean()).checkUrl("/"));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl(""));
    assertEquals("http://", (new AdMaterialBean()).checkUrl("http://"));
    assertEquals("https://example.org/example", (new AdMaterialBean()).checkUrl("https://example.org/example", true));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl(null, false));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl("url", true));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl("", true));
    assertThrows(ApiException.class, () -> (new AdMaterialBean()).checkUrl("url", false));
    assertEquals("http://", (new AdMaterialBean()).checkUrl("http://", false));
    assertEquals("/", (new AdMaterialBean()).checkUrl("/", false));
  }
}
