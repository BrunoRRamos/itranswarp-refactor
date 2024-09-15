package com.itranswarp.web.support;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@ContextConfiguration(classes = {MvcConfiguration.class})
@ExtendWith(SpringExtension.class)
class MvcConfigurationDiffblueTest {
  @Autowired
  private MvcConfiguration mvcConfiguration;

  /**
   * Method under test: {@link MvcConfiguration#createLocaleResolver()}
   */
  @Test
  void testCreateLocaleResolver() {
    // Arrange and Act
    LocaleResolver actualCreateLocaleResolverResult = mvcConfiguration.createLocaleResolver();

    // Assert
    assertTrue(actualCreateLocaleResolverResult instanceof CookieLocaleResolver);
    assertNull(((CookieLocaleResolver) actualCreateLocaleResolverResult).getDefaultTimeZone());
    assertTrue(((CookieLocaleResolver) actualCreateLocaleResolverResult).isLanguageTagCompliant());
    assertTrue(((CookieLocaleResolver) actualCreateLocaleResolverResult).isRejectInvalidCookies());
  }

  /**
   * Method under test: {@link MvcConfiguration#webMvcConfigurer(String)}
   */
  @Test
  void testWebMvcConfigurer() {
    // Arrange and Act
    WebMvcConfigurer actualWebMvcConfigurerResult = mvcConfiguration.webMvcConfigurer("Domain");

    // Assert
    assertNull(actualWebMvcConfigurerResult.getMessageCodesResolver());
    assertNull(actualWebMvcConfigurerResult.getValidator());
  }
}
