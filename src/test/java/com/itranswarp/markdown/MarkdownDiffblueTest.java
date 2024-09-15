package com.itranswarp.markdown;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Markdown.class})
@ExtendWith(SpringExtension.class)
class MarkdownDiffblueTest {
  @Autowired
  private Markdown markdown;

  /**
   * Method under test: {@link Markdown#toText(String)}
   */
  @Test
  void testToText() {
    // Arrange, Act and Assert
    assertEquals("Md", markdown.toText("Md"));
    assertEquals("\"", markdown.toText("\""));
    assertEquals("", markdown.toText(""));
  }

  /**
   * Method under test: {@link Markdown#toHtml(String)}
   */
  @Test
  void testToHtml() {
    // Arrange, Act and Assert
    assertEquals("<p>Md</p>\n", markdown.toHtml("Md"));
    assertEquals("<p>&quot;</p>\n", markdown.toHtml("\""));
    assertEquals("", markdown.toHtml(""));
  }

  /**
   * Method under test: {@link Markdown#ugcToHtml(String)}
   */
  @Test
  void testUgcToHtml() {
    // Arrange, Act and Assert
    assertEquals("<p>Md</p>\n", markdown.ugcToHtml("Md"));
    assertEquals("<p>&quot;</p>\n", markdown.ugcToHtml("\""));
    assertEquals("", markdown.ugcToHtml(""));
    assertThrows(ApiException.class, () -> markdown.ugcToHtml("Md", 3));
    assertThrows(ApiException.class, () -> markdown.ugcToHtml("\"", 3));
    assertEquals("", markdown.ugcToHtml("", 3));
  }
}
