package com.itranswarp.bean.setting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.itranswarp.enums.InputType;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WebsiteDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Website}
   */
  @Test
  void testNewWebsite() {
    // Arrange and Act
    Website actualWebsite = new Website();

    // Assert
    Map<String, String> settings = actualWebsite.getSettings();
    assertEquals(9, settings.size());
    assertEquals("", settings.get("copyright"));
    assertEquals("", settings.get("customFont"));
    assertEquals("", settings.get("customHeader"));
    assertEquals("", settings.get("keywords"));
    assertEquals("", settings.get("name"));
    assertEquals("", settings.get("xmlns"));
    List<SettingDefinition> settingDefinitions = actualWebsite.getSettingDefinitions();
    assertEquals(9, settingDefinitions.size());
    SettingDefinition getResult = settingDefinitions.get(6);
    assertEquals("Custom Fonts", getResult.description);
    SettingDefinition getResult2 = settingDefinitions.get(8);
    assertEquals("Custom footer", getResult2.description);
    SettingDefinition getResult3 = settingDefinitions.get(7);
    assertEquals("Custom header", getResult3.description);
    SettingDefinition getResult4 = settingDefinitions.get(1);
    assertEquals("Description", getResult4.description);
    SettingDefinition getResult5 = settingDefinitions.get(2);
    assertEquals("Language code", getResult5.description);
    SettingDefinition getResult6 = settingDefinitions.get(0);
    assertEquals("Name", getResult6.description);
    assertEquals("customFont", getResult.name);
    assertEquals("customFooter", getResult2.name);
    assertEquals("customHeader", getResult3.name);
    assertEquals("description", getResult4.name);
    assertEquals("lang", getResult5.name);
    assertEquals("name", getResult6.name);
    assertNull(actualWebsite.copyright);
    assertNull(actualWebsite.customFont);
    assertNull(actualWebsite.customFooter);
    assertNull(actualWebsite.customHeader);
    assertNull(actualWebsite.description);
    assertNull(actualWebsite.keywords);
    assertNull(actualWebsite.lang);
    assertNull(actualWebsite.name);
    assertNull(actualWebsite.xmlns);
    assertEquals(InputType.TEXT, getResult6.type);
    assertEquals(InputType.TEXT, getResult4.type);
    assertEquals(InputType.TEXT, getResult5.type);
    assertEquals(InputType.TEXT, getResult.type);
    assertEquals(InputType.TEXTAREA, getResult3.type);
    assertEquals(InputType.TEXTAREA, getResult2.type);
  }
}
