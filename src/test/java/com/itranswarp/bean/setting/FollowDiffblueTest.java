package com.itranswarp.bean.setting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.enums.InputType;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FollowDiffblueTest {
  /**
   * Method under test: {@link Follow#getFollows()}
   */
  @Test
  void testGetFollows() {
    // Arrange, Act and Assert
    assertTrue((new Follow()).getFollows().isEmpty());
  }

  /**
   * Method under test: {@link Follow#getFollows()}
   */
  @Test
  void testGetFollows2() {
    // Arrange
    Follow follow = new Follow();
    follow.facebook = "Facebook";

    // Act
    List<String[]> actualFollows = follow.getFollows();

    // Assert
    assertEquals(1, actualFollows.size());
    assertArrayEquals(new String[]{"facebook", "Facebook"}, actualFollows.get(0));
  }

  /**
   * Method under test: {@link Follow#getFollows()}
   */
  @Test
  void testGetFollows3() {
    // Arrange
    Follow follow = new Follow();
    follow.facebook = "";

    // Act and Assert
    assertTrue(follow.getFollows().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Follow}
   */
  @Test
  void testNewFollow() {
    // Arrange and Act
    Follow actualFollow = new Follow();

    // Assert
    Map<String, String> settings = actualFollow.getSettings();
    assertEquals(8, settings.size());
    assertEquals("", settings.get("facebook"));
    assertEquals("", settings.get("github"));
    assertEquals("", settings.get("reddit"));
    assertEquals("", settings.get("twitter"));
    assertEquals("", settings.get("weibo"));
    assertEquals("", settings.get("youtube"));
    List<SettingDefinition> settingDefinitions = actualFollow.getSettingDefinitions();
    assertEquals(8, settingDefinitions.size());
    SettingDefinition getResult = settingDefinitions.get(0);
    assertEquals("Facebook URL", getResult.description);
    SettingDefinition getResult2 = settingDefinitions.get(1);
    assertEquals("Github URL", getResult2.description);
    SettingDefinition getResult3 = settingDefinitions.get(2);
    assertEquals("Instagram URL", getResult3.description);
    SettingDefinition getResult4 = settingDefinitions.get(5);
    assertEquals("Twitter URL", getResult4.description);
    SettingDefinition getResult5 = settingDefinitions.get(6);
    assertEquals("Weibo URL", getResult5.description);
    SettingDefinition getResult6 = settingDefinitions.get(7);
    assertEquals("Youtube URL", getResult6.description);
    assertEquals("facebook", getResult.name);
    assertEquals("github", getResult2.name);
    assertEquals("instagram", getResult3.name);
    assertEquals("twitter", getResult4.name);
    assertEquals("weibo", getResult5.name);
    assertEquals("youtube", getResult6.name);
    assertNull(actualFollow.facebook);
    assertNull(actualFollow.github);
    assertNull(actualFollow.instagram);
    assertNull(actualFollow.linkedin);
    assertNull(actualFollow.reddit);
    assertNull(actualFollow.twitter);
    assertNull(actualFollow.weibo);
    assertNull(actualFollow.youtube);
    assertEquals(InputType.TEXT, getResult.type);
    assertEquals(InputType.TEXT, getResult2.type);
    assertEquals(InputType.TEXT, getResult3.type);
    assertEquals(InputType.TEXT, getResult4.type);
    assertEquals(InputType.TEXT, getResult5.type);
    assertEquals(InputType.TEXT, getResult6.type);
    assertTrue(actualFollow.getFollows().isEmpty());
  }
}
