package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.junit.jupiter.api.Test;

class TradingViewNodeRendererDiffblueTest {
  /**
   * Method under test: {@link TradingViewNodeRenderer#getNodeTypes()}
   */
  @Test
  void testGetNodeTypes() {
    // Arrange, Act and Assert
    assertEquals(1, (new TradingViewNodeRenderer(null, "Css Style", "Options")).getNodeTypes().size());
  }

  /**
   * Method under test:
   * {@link TradingViewNodeRenderer#TradingViewNodeRenderer(HtmlNodeRendererContext, String, String)}
   */
  @Test
  void testNewTradingViewNodeRenderer() {
    // Arrange and Act
    TradingViewNodeRenderer actualTradingViewNodeRenderer = new TradingViewNodeRenderer(null, "Css Style", "Options");

    // Assert
    assertEquals("Css Style", actualTradingViewNodeRenderer.cssStyle);
    assertEquals("Options", actualTradingViewNodeRenderer.options);
    assertNull(actualTradingViewNodeRenderer.context);
    assertEquals(1, actualTradingViewNodeRenderer.getNodeTypes().size());
  }
}
