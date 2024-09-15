package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.common.ApiException;
import com.itranswarp.enums.RefType;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

class MvcControllerDiffblueTest {
  /**
   * Method under test:
   * {@link MvcController#refRedirect(RefType, long, HttpServletResponse)}
   */
  @Test
  void testRefRedirect() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvcController mvcController = new MvcController();

    // Act
    ModelAndView actualRefRedirectResult = mvcController.refRedirect(RefType.ARTICLE, 1L, new Response());

    // Assert
    Map<String, Object> model = actualRefRedirectResult.getModel();
    assertTrue(model instanceof ModelMap);
    View view = actualRefRedirectResult.getView();
    assertTrue(view instanceof RedirectView);
    assertEquals("/article/1", ((RedirectView) view).getUrl());
    assertEquals("text/html;charset=ISO-8859-1", view.getContentType());
    assertNull(((RedirectView) view).getHosts());
    assertNull(actualRefRedirectResult.getViewName());
    assertNull(((RedirectView) view).getBeanName());
    assertNull(((RedirectView) view).getRequestContextAttribute());
    assertNull(((RedirectView) view).getApplicationContext());
    assertNull(actualRefRedirectResult.getStatus());
    assertFalse(actualRefRedirectResult.isEmpty());
    assertFalse(actualRefRedirectResult.isReference());
    assertFalse(((RedirectView) view).isExposePathVariables());
    assertFalse(((RedirectView) view).isPropagateQueryProperties());
    assertTrue(model.isEmpty());
    assertTrue(((RedirectView) view).getAttributesMap().isEmpty());
    assertTrue(((RedirectView) view).getStaticAttributes().isEmpty());
    assertTrue(actualRefRedirectResult.hasView());
    assertTrue(((RedirectView) view).isRedirectView());
    assertSame((ModelMap) model, actualRefRedirectResult.getModelMap());
  }

  /**
   * Method under test:
   * {@link MvcController#refRedirect(RefType, long, HttpServletResponse)}
   */
  @Test
  void testRefRedirect2() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvcController mvcController = new MvcController();

    // Act
    ModelAndView actualRefRedirectResult = mvcController.refRedirect(RefType.WIKI, 1L, new Response());

    // Assert
    Map<String, Object> model = actualRefRedirectResult.getModel();
    assertTrue(model instanceof ModelMap);
    View view = actualRefRedirectResult.getView();
    assertTrue(view instanceof RedirectView);
    assertEquals("/wiki/1", ((RedirectView) view).getUrl());
    assertEquals("text/html;charset=ISO-8859-1", view.getContentType());
    assertNull(((RedirectView) view).getHosts());
    assertNull(actualRefRedirectResult.getViewName());
    assertNull(((RedirectView) view).getBeanName());
    assertNull(((RedirectView) view).getRequestContextAttribute());
    assertNull(((RedirectView) view).getApplicationContext());
    assertNull(actualRefRedirectResult.getStatus());
    assertFalse(actualRefRedirectResult.isEmpty());
    assertFalse(actualRefRedirectResult.isReference());
    assertFalse(((RedirectView) view).isExposePathVariables());
    assertFalse(((RedirectView) view).isPropagateQueryProperties());
    assertTrue(model.isEmpty());
    assertTrue(((RedirectView) view).getAttributesMap().isEmpty());
    assertTrue(((RedirectView) view).getStaticAttributes().isEmpty());
    assertTrue(actualRefRedirectResult.hasView());
    assertTrue(((RedirectView) view).isRedirectView());
    assertSame((ModelMap) model, actualRefRedirectResult.getModelMap());
  }

  /**
   * Method under test:
   * {@link MvcController#signinLocal(String, String, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testSigninLocal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvcController mvcController = new MvcController();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(ApiException.class,
        () -> mvcController.signinLocal("jane.doe@example.org", "iloveyou", request, new Response()));
  }

  /**
   * Method under test:
   * {@link MvcController#signinByEth(String, String, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testSigninByEth() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvcController mvcController = new MvcController();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(ApiException.class,
        () -> mvcController.signinByEth("Not all who wander are lost", "Signature", request, new Response()));
  }

  /**
   * Method under test:
   * {@link MvcController#signOut(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testSignOut() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MvcController mvcController = new MvcController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSignOutResult = mvcController.signOut(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    Cookie[] cookies = response.getCookies();
    Cookie cookie = cookies[0];
    assertEquals("-deleted-", cookie.getValue());
    assertEquals("/", cookie.getPath());
    Map<String, String> attributes = cookie.getAttributes();
    assertEquals(4, attributes.size());
    assertEquals("/", attributes.get("Path"));
    assertEquals("0", attributes.get("Max-Age"));
    assertEquals("_session_", cookie.getName());
    assertEquals("redirect:/", actualSignOutResult);
    assertNull(cookie.getComment());
    assertNull(cookie.getDomain());
    assertEquals(0, cookie.getMaxAge());
    assertEquals(0, cookie.getVersion());
    assertEquals(1, cookies.length);
    assertFalse(cookie.getSecure());
    assertTrue(headerNames.contains("Set-Cookie"));
    String expectedGetResult = Boolean.FALSE.toString();
    assertEquals(expectedGetResult, attributes.get("Secure"));
    String expectedGetResult2 = Boolean.TRUE.toString();
    assertEquals(expectedGetResult2, attributes.get("HttpOnly"));
  }
}
