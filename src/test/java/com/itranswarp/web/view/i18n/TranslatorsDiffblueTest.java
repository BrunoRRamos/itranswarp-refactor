package com.itranswarp.web.view.i18n;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Translators.class})
@ExtendWith(SpringExtension.class)
class TranslatorsDiffblueTest {
  @Autowired
  private Translators translators;

  /**
   * Method under test: {@link Translators#init()}
   */
  @Test
  void testInit() throws IOException {
    // Arrange
    Translators translators = new Translators();

    // Act
    translators.init();

    // Assert
    Map<String, Translator> stringTranslatorMap = translators.translators;
    assertEquals(2, stringTranslatorMap.size());
    Translator getResult = stringTranslatorMap.get("zh_CN");
    assertTrue(getResult instanceof MapTranslator);
    Translator translator = translators.defaultTranslator;
    assertTrue(translator instanceof MapTranslator);
    assertEquals("English", translator.getDisplayName());
    List<Translators.Language> languages = translators.getLanguages();
    assertEquals(2, languages.size());
    Translators.Language getResult2 = languages.get(0);
    assertEquals("English", getResult2.name);
    Map<String, String> stringStringMap = ((MapTranslator) translator).translator;
    assertEquals(3, stringStringMap.size());
    assertEquals("Please enter keywords to search.", stringStringMap.get("~search-no-input-message"));
    assertEquals("Please make sure all words are spelled correctly, or try different keywords.",
        stringStringMap.get("~search-not-found-message"));
    assertEquals("Sorry, no results found.", stringStringMap.get("~search-not-found-error"));
    Map<String, String> stringStringMap2 = ((MapTranslator) getResult).translator;
    assertEquals(191, stringStringMap2.size());
    assertEquals("删除", stringStringMap2.get("Delete"));
    assertEquals("新板块", stringStringMap2.get("New Board"));
    assertEquals("时区", stringStringMap2.get("Timezone"));
    assertEquals("简体中文", getResult.getDisplayName());
    Translators.Language getResult3 = languages.get(1);
    assertEquals("简体中文", getResult3.name);
    assertEquals("en", translator.getLocaleName());
    assertEquals("en", getResult2.locale);
    assertEquals("zh_CN", getResult.getLocaleName());
    assertEquals("zh_CN", getResult3.locale);
    Translator expectedGetResult = translators.defaultTranslator;
    assertSame(expectedGetResult, stringTranslatorMap.get("en"));
  }

  /**
   * Method under test: {@link Translators#getTranslator(Locale)}
   */
  @Test
  void testGetTranslator() {
    // Arrange and Act
    Translator actualTranslator = translators.getTranslator(Locale.getDefault());

    // Assert
    Translator translator = translators.defaultTranslator;
    assertTrue(translator instanceof MapTranslator);
    assertSame(((MapTranslator) actualTranslator).translator, ((MapTranslator) translator).translator);
    assertSame(translators.defaultTranslator, actualTranslator);
  }

  /**
   * Method under test: {@link Translators#getTranslator(Locale)}
   */
  @Test
  void testGetTranslator2() {
    // Arrange and Act
    Translator actualTranslator = translators.getTranslator(new Locale("en"));

    // Assert
    Translator translator = translators.defaultTranslator;
    assertTrue(translator instanceof MapTranslator);
    assertSame(((MapTranslator) actualTranslator).translator, ((MapTranslator) translator).translator);
    assertSame(translators.defaultTranslator, actualTranslator);
  }

  /**
   * Method under test: {@link Translators#getLanguages()}
   */
  @Test
  void testGetLanguages() {
    // Arrange, Act and Assert
    assertNull((new Translators()).getLanguages());
  }

  /**
   * Method under test: {@link Translators.Language#Language(String, String)}
   */
  @Test
  void testLanguageNewLanguage() {
    // Arrange and Act
    Translators.Language actualLanguage = new Translators.Language("Name", "en");

    // Assert
    assertEquals("Name", actualLanguage.name);
    assertEquals("en", actualLanguage.locale);
  }
}
