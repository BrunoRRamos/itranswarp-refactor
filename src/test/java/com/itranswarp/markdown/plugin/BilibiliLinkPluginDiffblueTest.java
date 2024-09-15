package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.CharArrayWriter;
import org.commonmark.renderer.html.HtmlWriter;
import org.junit.jupiter.api.Test;

class BilibiliLinkPluginDiffblueTest {
  /**
   * Method under test:
   * {@link BilibiliLinkPlugin#render(HtmlWriter, String, String)}
   */
  @Test
  void testRender() {
    // Arrange
    BilibiliLinkPlugin bilibiliLinkPlugin = new BilibiliLinkPlugin();

    // Act and Assert
    assertFalse(bilibiliLinkPlugin.render(new HtmlWriter(new CharArrayWriter(1)), "https://example.org/example", "Dr"));
  }

  /**
   * Method under test:
   * {@link BilibiliLinkPlugin#render(HtmlWriter, String, String)}
   */
  @Test
  void testRender2() {
    // Arrange
    BilibiliLinkPlugin bilibiliLinkPlugin = new BilibiliLinkPlugin();

    // Act and Assert
    assertFalse(
        bilibiliLinkPlugin.render(new HtmlWriter(new CharArrayWriter(1)), "https://www.bilibili.com/video/", "Dr"));
  }
}
