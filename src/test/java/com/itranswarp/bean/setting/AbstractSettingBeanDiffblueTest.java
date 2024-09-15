package com.itranswarp.bean.setting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.enums.InputType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AbstractSettingBeanDiffblueTest {
  /**
   * Method under test: {@link AbstractSettingBean#getSettings()}
   */
  @Test
  void testGetSettings() {
    // Arrange and Act
    Map<String, String> actualSettings = (new Follow()).getSettings();

    // Assert
    assertEquals(8, actualSettings.size());
    assertEquals("", actualSettings.get("facebook"));
    assertEquals("", actualSettings.get("github"));
    assertEquals("", actualSettings.get("instagram"));
    assertEquals("", actualSettings.get("linkedin"));
    assertEquals("", actualSettings.get("reddit"));
    assertEquals("", actualSettings.get("twitter"));
    assertEquals("", actualSettings.get("weibo"));
    assertEquals("", actualSettings.get("youtube"));
  }

  /**
   * Method under test: {@link AbstractSettingBean#getSettings()}
   */
  @Test
  void testGetSettings2() {
    // Arrange
    Follow follow = new Follow();
    follow.facebook = "Facebook";

    // Act
    Map<String, String> actualSettings = follow.getSettings();

    // Assert
    assertEquals(8, actualSettings.size());
    assertEquals("", actualSettings.get("github"));
    assertEquals("", actualSettings.get("instagram"));
    assertEquals("", actualSettings.get("linkedin"));
    assertEquals("", actualSettings.get("reddit"));
    assertEquals("", actualSettings.get("twitter"));
    assertEquals("", actualSettings.get("weibo"));
    assertEquals("", actualSettings.get("youtube"));
    assertEquals("Facebook", actualSettings.get("facebook"));
  }

  /**
   * Method under test: {@link AbstractSettingBean#setSettings(Map)}
   */
  @Test
  void testSetSettings() {
    // Arrange
    Follow follow = new Follow();

    // Act
    follow.setSettings(new HashMap<>());

    // Assert that nothing has changed
    assertEquals("", follow.facebook);
    assertEquals("", follow.github);
    assertEquals("", follow.instagram);
    assertEquals("", follow.linkedin);
    assertEquals("", follow.reddit);
    assertEquals("", follow.twitter);
    assertEquals("", follow.weibo);
    assertEquals("", follow.youtube);
  }

  /**
   * Method under test: {@link AbstractSettingBean#getSettingDefinitions()}
   */
  @Test
  void testGetSettingDefinitions() {
    // Arrange and Act
    List<SettingDefinition> actualSettingDefinitions = (new Follow()).getSettingDefinitions();

    // Assert
    assertEquals(8, actualSettingDefinitions.size());
    SettingDefinition getResult = actualSettingDefinitions.get(0);
    assertEquals("Facebook URL", getResult.description);
    SettingDefinition getResult2 = actualSettingDefinitions.get(1);
    assertEquals("Github URL", getResult2.description);
    SettingDefinition getResult3 = actualSettingDefinitions.get(2);
    assertEquals("Instagram URL", getResult3.description);
    SettingDefinition getResult4 = actualSettingDefinitions.get(3);
    assertEquals("Linkedin URL", getResult4.description);
    SettingDefinition getResult5 = actualSettingDefinitions.get(4);
    assertEquals("Reddit URL", getResult5.description);
    SettingDefinition getResult6 = actualSettingDefinitions.get(5);
    assertEquals("Twitter URL", getResult6.description);
    SettingDefinition getResult7 = actualSettingDefinitions.get(6);
    assertEquals("Weibo URL", getResult7.description);
    SettingDefinition getResult8 = actualSettingDefinitions.get(7);
    assertEquals("Youtube URL", getResult8.description);
    assertEquals("facebook", getResult.name);
    assertEquals("github", getResult2.name);
    assertEquals("instagram", getResult3.name);
    assertEquals("linkedin", getResult4.name);
    assertEquals("reddit", getResult5.name);
    assertEquals("twitter", getResult6.name);
    assertEquals("weibo", getResult7.name);
    assertEquals("youtube", getResult8.name);
    assertEquals(InputType.TEXT, getResult.type);
    assertEquals(InputType.TEXT, getResult2.type);
    assertEquals(InputType.TEXT, getResult3.type);
    assertEquals(InputType.TEXT, getResult4.type);
    assertEquals(InputType.TEXT, getResult5.type);
    assertEquals(InputType.TEXT, getResult6.type);
    assertEquals(InputType.TEXT, getResult7.type);
    assertEquals(InputType.TEXT, getResult8.type);
  }

  /**
   * Method under test: {@link AbstractSettingBean#getInputType(String)}
   */
  @Test
  void testGetInputType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Follow()).getInputType("Name"));
  }
}
