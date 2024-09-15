package com.itranswarp.bean.setting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.enums.InputType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SecurityDiffblueTest {
  /**
   * Method under test: {@link Security#getIpBlacklistAsSet()}
   */
  @Test
  void testGetIpBlacklistAsSet() {
    // Arrange, Act and Assert
    assertTrue((new Security()).getIpBlacklistAsSet().isEmpty());
  }

  /**
   * Method under test: {@link Security#getIpBlacklistAsSet()}
   */
  @Test
  void testGetIpBlacklistAsSet2() {
    // Arrange
    Security security = new Security();
    security.ipBlacklist = "foo";

    // Act
    Set<String> actualIpBlacklistAsSet = security.getIpBlacklistAsSet();

    // Assert
    assertEquals(1, actualIpBlacklistAsSet.size());
    assertTrue(actualIpBlacklistAsSet.contains("foo"));
  }

  /**
   * Method under test: {@link Security#getIpBlacklistAsSet()}
   */
  @Test
  void testGetIpBlacklistAsSet3() {
    // Arrange
    Security security = new Security();
    security.ipBlacklist = "\n";

    // Act and Assert
    assertTrue(security.getIpBlacklistAsSet().isEmpty());
  }

  /**
   * Method under test: {@link Security#getSpamKeywordsAsList()}
   */
  @Test
  void testGetSpamKeywordsAsList() {
    // Arrange, Act and Assert
    assertTrue((new Security()).getSpamKeywordsAsList().isEmpty());
  }

  /**
   * Method under test: {@link Security#getSpamKeywordsAsList()}
   */
  @Test
  void testGetSpamKeywordsAsList2() {
    // Arrange
    Security security = new Security();
    security.spamKeywords = "foo";

    // Act
    List<String> actualSpamKeywordsAsList = security.getSpamKeywordsAsList();

    // Assert
    assertEquals(1, actualSpamKeywordsAsList.size());
    assertEquals("foo", actualSpamKeywordsAsList.get(0));
  }

  /**
   * Method under test: {@link Security#getSpamKeywordsAsList()}
   */
  @Test
  void testGetSpamKeywordsAsList3() {
    // Arrange
    Security security = new Security();
    security.spamKeywords = "\n";

    // Act and Assert
    assertTrue(security.getSpamKeywordsAsList().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Security}
   */
  @Test
  void testNewSecurity() {
    // Arrange and Act
    Security actualSecurity = new Security();

    // Assert
    Map<String, String> settings = actualSecurity.getSettings();
    assertEquals(2, settings.size());
    assertEquals("", settings.get("ipBlacklist"));
    assertEquals("", settings.get("spamKeywords"));
    List<SettingDefinition> settingDefinitions = actualSecurity.getSettingDefinitions();
    assertEquals(2, settingDefinitions.size());
    SettingDefinition getResult = settingDefinitions.get(0);
    assertEquals("Forbidden IPs", getResult.description);
    SettingDefinition getResult2 = settingDefinitions.get(1);
    assertEquals("Spam keywords", getResult2.description);
    assertEquals("ipBlacklist", getResult.name);
    assertEquals("spamKeywords", getResult2.name);
    assertNull(actualSecurity.ipBlacklist);
    assertNull(actualSecurity.spamKeywords);
    assertEquals(InputType.TEXTAREA, getResult.type);
    assertEquals(InputType.TEXTAREA, getResult2.type);
    assertTrue(actualSecurity.getSpamKeywordsAsList().isEmpty());
    assertTrue(actualSecurity.getIpBlacklistAsSet().isEmpty());
  }
}
