package com.itranswarp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.common.ApiException;
import com.itranswarp.enums.Role;
import com.itranswarp.model.User;
import com.itranswarp.oauth.OAuthAuthentication;
import org.junit.jupiter.api.Test;

class UserServiceDiffblueTest {
  /**
   * Method under test: {@link UserService#getUsersByIds(long[])}
   */
  @Test
  void testGetUsersByIds() {
    // Arrange, Act and Assert
    assertTrue((new UserService()).getUsersByIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link UserService#createOAuthUser(String, boolean, OAuthAuthentication)}
   */
  @Test
  void testCreateOAuthUser() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new UserService()).createOAuthUser("local", true, null));
    assertThrows(RuntimeException.class, () -> (new UserService()).createOAuthUser("eth", true, null));
  }

  /**
   * Method under test: {@link UserService#updateUserPassword(long, String)}
   */
  @Test
  void testUpdateUserPassword() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new UserService()).updateUserPassword(1L, "iloveyou"));
  }

  /**
   * Method under test: {@link UserService#lockUser(User, int)}
   */
  @Test
  void testLockUser() {
    // Arrange
    UserService userService = new UserService();
    User user = new User();
    user.role = Role.ADMIN;

    // Act and Assert
    assertThrows(ApiException.class, () -> userService.lockUser(user, 0));
  }

  /**
   * Method under test: {@link UserService#checkName(String)}
   */
  @Test
  void testCheckName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new UserService()).checkName("Name"));
    assertEquals("(unamed)", (new UserService()).checkName(null));
  }

  /**
   * Method under test: {@link UserService#checkEmail(String)}
   */
  @Test
  void testCheckEmail() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new UserService()).checkEmail("42"));
    assertEquals("u@uuu", (new UserService()).checkEmail("  U@UUU "));
    assertThrows(ApiException.class, () -> (new UserService()).checkEmail("Invalid email address."));
    assertThrows(ApiException.class, () -> (new UserService()).checkEmail(null));
    assertThrows(ApiException.class, () -> (new UserService()).checkEmail("42  U@UUU "));
  }

  /**
   * Method under test: {@link UserService#checkImageUrl(String)}
   */
  @Test
  void testCheckImageUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", (new UserService()).checkImageUrl("https://example.org/example"));
    assertEquals("/", (new UserService()).checkImageUrl("/"));
    assertThrows(ApiException.class, () -> (new UserService()).checkImageUrl("Url"));
    assertEquals("about:blank", (new UserService()).checkImageUrl(null));
    assertEquals("about:blank", (new UserService()).checkImageUrl(""));
    assertEquals("http://", (new UserService()).checkImageUrl("http://"));
  }
}
