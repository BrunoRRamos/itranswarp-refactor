package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.CharArrayWriter;
import org.commonmark.renderer.html.HtmlWriter;
import org.junit.jupiter.api.Test;

class QQVideoLinkPluginDiffblueTest {
  /**
   * Method under test:
   * {@link QQVideoLinkPlugin#render(HtmlWriter, String, String)}
   */
  @Test
  void testRender() {
    // Arrange
    QQVideoLinkPlugin qqVideoLinkPlugin = new QQVideoLinkPlugin();

    // Act and Assert
    assertFalse(qqVideoLinkPlugin.render(new HtmlWriter(new CharArrayWriter(1)), "https://example.org/example", "Dr"));
  }

  /**
   * Method under test:
   * {@link QQVideoLinkPlugin#render(HtmlWriter, String, String)}
   */
  @Test
  void testRender2() {
    // Arrange
    QQVideoLinkPlugin qqVideoLinkPlugin = new QQVideoLinkPlugin();

    // Act and Assert
    assertFalse(qqVideoLinkPlugin.render(new HtmlWriter(new CharArrayWriter(1)), "https://v.qq.com/x/cover/", "Dr"));
  }
}
