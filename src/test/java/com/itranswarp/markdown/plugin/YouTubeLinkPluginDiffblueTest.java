package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.CharArrayWriter;
import org.commonmark.renderer.html.HtmlWriter;
import org.junit.jupiter.api.Test;

class YouTubeLinkPluginDiffblueTest {
  /**
   * Method under test:
   * {@link YouTubeLinkPlugin#render(HtmlWriter, String, String)}
   */
  @Test
  void testRender() {
    // Arrange
    YouTubeLinkPlugin youTubeLinkPlugin = new YouTubeLinkPlugin();

    // Act and Assert
    assertFalse(youTubeLinkPlugin.render(new HtmlWriter(new CharArrayWriter(1)), "https://example.org/example", "Dr"));
  }

  /**
   * Method under test:
   * {@link YouTubeLinkPlugin#render(HtmlWriter, String, String)}
   */
  @Test
  void testRender2() {
    // Arrange
    YouTubeLinkPlugin youTubeLinkPlugin = new YouTubeLinkPlugin();

    // Act and Assert
    assertFalse(
        youTubeLinkPlugin.render(new HtmlWriter(new CharArrayWriter(1)), "https://www.youtube.com/watch?v=", "Dr"));
  }
}
