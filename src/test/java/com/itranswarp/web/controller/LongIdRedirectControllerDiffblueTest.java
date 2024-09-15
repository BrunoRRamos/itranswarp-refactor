package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LongIdRedirectControllerDiffblueTest {
  /**
   * Method under test: {@link LongIdRedirectController#category(String)}
   */
  @Test
  void testCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/category/2095166658076683257",
        (new LongIdRedirectController()).category("99999999999999999999999999999999999999999999999999"));
    assertEquals("redirect:/wiki/2095166658076683257/2095166658076683257", (new LongIdRedirectController()).category(
        "99999999999999999999999999999999999999999999999999", "99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#discuss(String)}
   */
  @Test
  void testDiscuss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/discuss/2095166658076683257",
        (new LongIdRedirectController()).discuss("99999999999999999999999999999999999999999999999999"));
    assertEquals("redirect:/discuss/2095166658076683257/2095166658076683257", (new LongIdRedirectController()).discuss(
        "99999999999999999999999999999999999999999999999999", "99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#article(String)}
   */
  @Test
  void testArticle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/article/2095166658076683257",
        (new LongIdRedirectController()).article("99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#wiki(String)}
   */
  @Test
  void testWiki() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/wiki/2095166658076683257",
        (new LongIdRedirectController()).wiki("99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#attachments(String)}
   */
  @Test
  void testAttachments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/files/attachments/2095166658076683257",
        (new LongIdRedirectController()).attachments("99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#attachmentsOf0(String)}
   */
  @Test
  void testAttachmentsOf0() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/files/attachments/2095166658076683257/0",
        (new LongIdRedirectController()).attachmentsOf0("99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#attachmentsOfL(String)}
   */
  @Test
  void testAttachmentsOfL() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/files/attachments/2095166658076683257/l",
        (new LongIdRedirectController()).attachmentsOfL("99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#attachmentsOfM(String)}
   */
  @Test
  void testAttachmentsOfM() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/files/attachments/2095166658076683257/m",
        (new LongIdRedirectController()).attachmentsOfM("99999999999999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link LongIdRedirectController#attachmentsOfS(String)}
   */
  @Test
  void testAttachmentsOfS() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("redirect:/files/attachments/2095166658076683257/s",
        (new LongIdRedirectController()).attachmentsOfS("99999999999999999999999999999999999999999999999999"));
  }
}
