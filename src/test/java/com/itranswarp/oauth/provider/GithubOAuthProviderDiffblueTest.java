package com.itranswarp.oauth.provider;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class GithubOAuthProviderDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link GithubOAuthProvider.GitHubAccessTokenResponse}
   */
  @Test
  void testGitHubAccessTokenResponseNewGitHubAccessTokenResponse() {
    // Arrange, Act and Assert
    assertNull((new GithubOAuthProvider.GitHubAccessTokenResponse()).access_token);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link GithubOAuthProvider.GitHubUser}
   */
  @Test
  void testGitHubUserNewGitHubUser() {
    // Arrange and Act
    GithubOAuthProvider.GitHubUser actualGitHubUser = new GithubOAuthProvider.GitHubUser();

    // Assert
    assertNull(actualGitHubUser.avatar_url);
    assertNull(actualGitHubUser.html_url);
    assertNull(actualGitHubUser.name);
    assertNull(actualGitHubUser.node_id);
    assertNull(actualGitHubUser.type);
  }
}
