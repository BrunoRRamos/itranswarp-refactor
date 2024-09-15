package com.itranswarp.bean.setting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.itranswarp.enums.InputType;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SnippetDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Snippet}
   */
  @Test
  void testNewSnippet() {
    // Arrange and Act
    Snippet actualSnippet = new Snippet();

    // Assert
    Map<String, String> settings = actualSnippet.getSettings();
    assertEquals(10, settings.size());
    assertEquals("", settings.get("bodyTop"));
    assertEquals("", settings.get("contentBottom"));
    assertEquals("", settings.get("contentTop"));
    assertEquals("", settings.get("indexBottom"));
    assertEquals("", settings.get("indexTop"));
    assertEquals("", settings.get("sidebarLeftTop"));
    List<SettingDefinition> settingDefinitions = actualSnippet.getSettingDefinitions();
    assertEquals(10, settingDefinitions.size());
    SettingDefinition getResult = settingDefinitions.get(2);
    assertEquals("Body top", getResult.description);
    SettingDefinition getResult2 = settingDefinitions.get(1);
    assertEquals("Index bottom", getResult2.description);
    SettingDefinition getResult3 = settingDefinitions.get(0);
    assertEquals("Index top", getResult3.description);
    SettingDefinition getResult4 = settingDefinitions.get(7);
    assertEquals("Left side bar bottom", getResult4.description);
    SettingDefinition getResult5 = settingDefinitions.get(9);
    assertEquals("Right side bar bottom", getResult5.description);
    SettingDefinition getResult6 = settingDefinitions.get(8);
    assertEquals("Right side bar top", getResult6.description);
    assertEquals("bodyTop", getResult.name);
    assertEquals("indexBottom", getResult2.name);
    assertEquals("indexTop", getResult3.name);
    assertEquals("sidebarLeftBottom", getResult4.name);
    assertEquals("sidebarRightBottom", getResult5.name);
    assertEquals("sidebarRightTop", getResult6.name);
    assertNull(actualSnippet.bodyBottom);
    assertNull(actualSnippet.bodyTop);
    assertNull(actualSnippet.contentBottom);
    assertNull(actualSnippet.contentTop);
    assertNull(actualSnippet.indexBottom);
    assertNull(actualSnippet.indexTop);
    assertNull(actualSnippet.sidebarLeftBottom);
    assertNull(actualSnippet.sidebarLeftTop);
    assertNull(actualSnippet.sidebarRightBottom);
    assertNull(actualSnippet.sidebarRightTop);
    assertEquals(InputType.TEXTAREA, getResult3.type);
    assertEquals(InputType.TEXTAREA, getResult2.type);
    assertEquals(InputType.TEXTAREA, getResult.type);
    assertEquals(InputType.TEXTAREA, getResult4.type);
    assertEquals(InputType.TEXTAREA, getResult6.type);
    assertEquals(InputType.TEXTAREA, getResult5.type);
  }
}
