package com.itranswarp.markdown.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TradingViewSecurityPluginDiffblueTest {
  /**
   * Method under test: {@link TradingViewSecurityPlugin#init()}
   */
  @Test
  void testInit() {
    // Arrange
    TradingViewSecurityPlugin tradingViewSecurityPlugin = new TradingViewSecurityPlugin();

    // Act
    tradingViewSecurityPlugin.init();

    // Assert
    assertEquals("pt_BR", tradingViewSecurityPlugin.locale);
    assertEquals("width:100%;height:480px", tradingViewSecurityPlugin.cssStyle);
  }
}
