package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.common.ApiException;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ExtApiControllerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ExtApiController.ChatGptInput}
   */
  @Test
  void testChatGptInputNewChatGptInput() {
    // Arrange, Act and Assert
    assertNull((new ExtApiController.ChatGptInput()).content);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExtApiController.ChatGptOutput}
   */
  @Test
  void testChatGptOutputNewChatGptOutput() {
    // Arrange, Act and Assert
    assertNull((new ExtApiController.ChatGptOutput()).choices);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExtApiController.ChatGptOutput.Choice}
   */
  @Test
  void testChatGptOutput_ChoiceNewChoice() {
    // Arrange, Act and Assert
    assertNull((new ExtApiController.ChatGptOutput.Choice()).message);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExtApiController.ChatGptOutput.Message}
   */
  @Test
  void testChatGptOutput_MessageNewMessage() {
    // Arrange and Act
    ExtApiController.ChatGptOutput.Message actualMessage = new ExtApiController.ChatGptOutput.Message();

    // Assert
    assertNull(actualMessage.content);
    assertNull(actualMessage.role);
  }

  /**
   * Method under test: {@link ExtApiController#chatGptRateLimit()}
   */
  @Test
  void testChatGptRateLimit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, Boolean> actualChatGptRateLimitResult = (new ExtApiController()).chatGptRateLimit();

    // Assert
    assertEquals(1, actualChatGptRateLimitResult.size());
    assertTrue(actualChatGptRateLimitResult.get("result"));
  }

  /**
   * Method under test:
   * {@link ExtApiController#chatGpt(ExtApiController.ChatGptInput)}
   */
  @Test
  void testChatGpt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ExtApiController extApiController = new ExtApiController();
    ExtApiController.ChatGptInput input = new ExtApiController.ChatGptInput();
    input.content = "Not all who wander are lost";

    // Act and Assert
    assertThrows(ApiException.class, () -> extApiController.chatGpt(input));
  }

  /**
   * Method under test:
   * {@link ExtApiController#remoteCodeRun(ExtApiController.RemoteCodeRunInput)}
   */
  @Test
  void testRemoteCodeRun() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ExtApiController extApiController = new ExtApiController();
    ExtApiController.RemoteCodeRunInput input = new ExtApiController.RemoteCodeRunInput();
    input.code = "Code";
    input.language = "en";

    // Act and Assert
    assertThrows(ApiException.class, () -> extApiController.remoteCodeRun(input));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExtApiController.RemoteCodeRunInput}
   */
  @Test
  void testRemoteCodeRunInputNewRemoteCodeRunInput() {
    // Arrange and Act
    ExtApiController.RemoteCodeRunInput actualRemoteCodeRunInput = new ExtApiController.RemoteCodeRunInput();

    // Assert
    assertNull(actualRemoteCodeRunInput.code);
    assertNull(actualRemoteCodeRunInput.language);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ExtApiController.RemoteCodeRunResult}
   */
  @Test
  void testRemoteCodeRunResultNewRemoteCodeRunResult() {
    // Arrange and Act
    ExtApiController.RemoteCodeRunResult actualRemoteCodeRunResult = new ExtApiController.RemoteCodeRunResult();

    // Assert
    assertNull(actualRemoteCodeRunResult.output);
    assertFalse(actualRemoteCodeRunResult.error);
    assertFalse(actualRemoteCodeRunResult.timeout);
    assertFalse(actualRemoteCodeRunResult.truncated);
  }
}
