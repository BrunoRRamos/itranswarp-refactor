package com.itranswarp.web.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GlobalFilterRegistrationBeanDiffblueTest {
  /**
   * Method under test: {@link GlobalFilterRegistrationBean#init()}
   */
  @Test
  void testInit() {
    // Arrange
    GlobalFilterRegistrationBean globalFilterRegistrationBean = new GlobalFilterRegistrationBean();

    // Act
    globalFilterRegistrationBean.init();

    // Assert that nothing has changed
    assertTrue(globalFilterRegistrationBean.getFilter() instanceof GlobalFilterRegistrationBean.GlobalFilter);
    Collection<String> urlPatterns = globalFilterRegistrationBean.getUrlPatterns();
    assertEquals(1, urlPatterns.size());
    assertTrue(urlPatterns instanceof Set);
    assertEquals(100, globalFilterRegistrationBean.getOrder());
    assertTrue(urlPatterns.contains("/*"));
  }
}
