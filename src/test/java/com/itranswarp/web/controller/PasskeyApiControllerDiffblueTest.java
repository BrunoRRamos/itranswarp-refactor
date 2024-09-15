package com.itranswarp.web.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.itranswarp.common.ApiException;
import com.webauthn4j.data.attestation.authenticator.AuthenticatorData;
import com.webauthn4j.data.attestation.authenticator.Curve;
import com.webauthn4j.data.attestation.authenticator.EC2COSEKey;
import com.webauthn4j.data.attestation.statement.COSEAlgorithmIdentifier;
import com.webauthn4j.data.attestation.statement.COSEKeyOperation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class PasskeyApiControllerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.CredentialBean}
   */
  @Test
  void testCredentialBeanNewCredentialBean() {
    // Arrange and Act
    PasskeyApiController.CredentialBean actualCredentialBean = new PasskeyApiController.CredentialBean();

    // Assert
    assertEquals("public-key", actualCredentialBean.type);
    assertNull(actualCredentialBean.transports);
    assertNull(actualCredentialBean.id);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.GetOptionsBean}
   */
  @Test
  void testGetOptionsBeanNewGetOptionsBean() {
    // Arrange and Act
    PasskeyApiController.GetOptionsBean actualGetOptionsBean = new PasskeyApiController.GetOptionsBean();

    // Assert
    assertNull(actualGetOptionsBean.challenge);
    assertNull(actualGetOptionsBean.rpId);
    assertEquals(0, actualGetOptionsBean.allowCredentials.length);
    assertEquals(0L, actualGetOptionsBean.timeout);
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parsePublicKey(PasskeyApiController.RegisterBean, String, String)}
   */
  @Test
  void testParsePublicKey() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.RegisterBean.RegisterResponseBean registerResponseBean = new PasskeyApiController.RegisterBean.RegisterResponseBean();
    registerResponseBean.attestationObject = "Attestation Object";
    registerResponseBean.clientDataJSON = "Client Data JSON";
    registerResponseBean.transports = new String[]{"Transports"};
    PasskeyApiController.RegisterBean client = new PasskeyApiController.RegisterBean();
    client.authenticatorAttachment = "Authenticator Attachment";
    client.id = "42";
    client.rawId = "42";
    client.response = registerResponseBean;
    client.type = "Type";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parsePublicKey(client, "Origin", "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parsePublicKey(PasskeyApiController.RegisterBean, String, String)}
   */
  @Test
  void testParsePublicKey2() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.RegisterBean.RegisterResponseBean registerResponseBean = new PasskeyApiController.RegisterBean.RegisterResponseBean();
    registerResponseBean.attestationObject = "Attestation Object";
    registerResponseBean.clientDataJSON = "Client Data JSON";
    registerResponseBean.transports = new String[]{"Transports"};
    PasskeyApiController.RegisterBean client = new PasskeyApiController.RegisterBean();
    client.authenticatorAttachment = "Authenticator Attachment";
    client.id = "public-key";
    client.rawId = "42";
    client.response = registerResponseBean;
    client.type = "Type";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parsePublicKey(client, "Origin", "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parsePublicKey(PasskeyApiController.RegisterBean, String, String)}
   */
  @Test
  void testParsePublicKey3() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.RegisterBean.RegisterResponseBean registerResponseBean = new PasskeyApiController.RegisterBean.RegisterResponseBean();
    registerResponseBean.attestationObject = "Attestation Object";
    registerResponseBean.clientDataJSON = "Client Data JSON";
    registerResponseBean.transports = new String[]{"Transports"};
    PasskeyApiController.RegisterBean client = new PasskeyApiController.RegisterBean();
    client.authenticatorAttachment = "Authenticator Attachment";
    client.id = null;
    client.rawId = "42";
    client.response = registerResponseBean;
    client.type = "Type";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parsePublicKey(client, "Origin", "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parsePublicKey(PasskeyApiController.RegisterBean, String, String)}
   */
  @Test
  void testParsePublicKey4() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.RegisterBean.RegisterResponseBean registerResponseBean = new PasskeyApiController.RegisterBean.RegisterResponseBean();
    registerResponseBean.attestationObject = "Attestation Object";
    registerResponseBean.clientDataJSON = "Client Data JSON";
    registerResponseBean.transports = new String[]{"Transports"};
    PasskeyApiController.RegisterBean client = new PasskeyApiController.RegisterBean();
    client.authenticatorAttachment = "Authenticator Attachment";
    client.id = "42";
    client.rawId = "42";
    client.response = registerResponseBean;
    client.type = "public-key";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parsePublicKey(client, "Origin", "42"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.PubKeyCredParamsBean}
   */
  @Test
  void testPubKeyCredParamsBeanNewPubKeyCredParamsBean() {
    // Arrange and Act
    PasskeyApiController.PubKeyCredParamsBean actualPubKeyCredParamsBean = new PasskeyApiController.PubKeyCredParamsBean();

    // Assert
    assertEquals("public-key", actualPubKeyCredParamsBean.type);
    assertEquals(-7, actualPubKeyCredParamsBean.alg);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.RegisterBean}
   */
  @Test
  void testRegisterBeanNewRegisterBean() {
    // Arrange and Act
    PasskeyApiController.RegisterBean actualRegisterBean = new PasskeyApiController.RegisterBean();

    // Assert
    assertNull(actualRegisterBean.response);
    assertNull(actualRegisterBean.authenticatorAttachment);
    assertNull(actualRegisterBean.id);
    assertNull(actualRegisterBean.rawId);
    assertNull(actualRegisterBean.type);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.RegisterBean.RegisterResponseBean}
   */
  @Test
  void testRegisterBean_RegisterResponseBeanNewRegisterResponseBean() {
    // Arrange and Act
    PasskeyApiController.RegisterBean.RegisterResponseBean actualRegisterResponseBean = new PasskeyApiController.RegisterBean.RegisterResponseBean();

    // Assert
    assertNull(actualRegisterResponseBean.transports);
    assertNull(actualRegisterResponseBean.attestationObject);
    assertNull(actualRegisterResponseBean.clientDataJSON);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.RegisterOptionsBean}
   */
  @Test
  void testRegisterOptionsBeanNewRegisterOptionsBean() {
    // Arrange and Act
    PasskeyApiController.RegisterOptionsBean actualRegisterOptionsBean = new PasskeyApiController.RegisterOptionsBean();

    // Assert
    assertEquals("none", actualRegisterOptionsBean.attestation);
    Map<String, Object> stringObjectMap = actualRegisterOptionsBean.authenticatorSelection;
    assertEquals(3, stringObjectMap.size());
    assertEquals("platform", stringObjectMap.get("authenticatorAttachment"));
    PasskeyApiController.PubKeyCredParamsBean[] pubKeyCredParamsBeanArray = actualRegisterOptionsBean.pubKeyCredParams;
    PasskeyApiController.PubKeyCredParamsBean pubKeyCredParamsBean = pubKeyCredParamsBeanArray[0];
    assertEquals("public-key", pubKeyCredParamsBean.type);
    assertEquals("required", stringObjectMap.get("residentKey"));
    assertNull(actualRegisterOptionsBean.challenge);
    assertNull(actualRegisterOptionsBean.rp);
    assertNull(actualRegisterOptionsBean.user);
    assertEquals(-7, pubKeyCredParamsBean.alg);
    assertEquals(0, actualRegisterOptionsBean.excludeCredentials.length);
    assertEquals(0L, actualRegisterOptionsBean.timeout);
    Map<String, Object> stringObjectMap2 = actualRegisterOptionsBean.extensions;
    assertEquals(1, stringObjectMap2.size());
    assertEquals(1, pubKeyCredParamsBeanArray.length);
    assertTrue(stringObjectMap.containsKey("requireResidentKey"));
    Object expectedGetResult = stringObjectMap.get("requireResidentKey");
    assertSame(expectedGetResult, stringObjectMap2.get("credProps"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.SigninBean}
   */
  @Test
  void testSigninBeanNewSigninBean() {
    // Arrange and Act
    PasskeyApiController.SigninBean actualSigninBean = new PasskeyApiController.SigninBean();

    // Assert
    assertNull(actualSigninBean.response);
    assertNull(actualSigninBean.id);
    assertNull(actualSigninBean.rawId);
    assertNull(actualSigninBean.type);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PasskeyApiController.SigninBean.SigninResponseBean}
   */
  @Test
  void testSigninBean_SigninResponseBeanNewSigninResponseBean() {
    // Arrange and Act
    PasskeyApiController.SigninBean.SigninResponseBean actualSigninResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();

    // Assert
    assertNull(actualSigninResponseBean.authenticatorData);
    assertNull(actualSigninResponseBean.clientDataJSON);
    assertNull(actualSigninResponseBean.signature);
    assertNull(actualSigninResponseBean.userHandle);
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#signinRequest(PasskeyApiController.SigninBean, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testSigninRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "User Handle";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = "42";
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "Type";
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.signinRequest(client, request, new Response()));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#signinRequest(PasskeyApiController.SigninBean, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testSigninRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "User Handle";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = "https";
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "Type";
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.signinRequest(client, request, new Response()));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#signinRequest(PasskeyApiController.SigninBean, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  void testSigninRequest3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "User Handle";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = null;
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "Type";
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.signinRequest(client, request, new Response()));
  }

  /**
   * Method under test: {@link PasskeyApiController#decodeUserHandle(String)}
   */
  @Test
  void testDecodeUserHandle() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PasskeyApiController()).decodeUserHandle("42"));
    assertEquals(8514945243295869543L, (new PasskeyApiController()).decodeUserHandle("displayName"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parseFromSignature(PasskeyApiController.SigninBean, String, String)}
   */
  @Test
  void testParseFromSignature() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "User Handle";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = "42";
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "Type";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parseFromSignature(client, "Origin", "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parseFromSignature(PasskeyApiController.SigninBean, String, String)}
   */
  @Test
  void testParseFromSignature2() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "User Handle";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = "public-key";
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "Type";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parseFromSignature(client, "Origin", "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parseFromSignature(PasskeyApiController.SigninBean, String, String)}
   */
  @Test
  void testParseFromSignature3() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "User Handle";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = null;
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "Type";

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController.parseFromSignature(client, "Origin", "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#parseFromSignature(PasskeyApiController.SigninBean, String, String)}
   */
  @Test
  void testParseFromSignature4() {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    PasskeyApiController.SigninBean.SigninResponseBean signinResponseBean = new PasskeyApiController.SigninBean.SigninResponseBean();
    signinResponseBean.authenticatorData = "Authenticator Data";
    signinResponseBean.clientDataJSON = "Client Data JSON";
    signinResponseBean.signature = "Signature";
    signinResponseBean.userHandle = "42";
    PasskeyApiController.SigninBean client = new PasskeyApiController.SigninBean();
    client.id = "42";
    client.rawId = "42";
    client.response = signinResponseBean;
    client.type = "public-key";

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> passkeyApiController.parseFromSignature(client, "Origin", "42"));
  }

  /**
   * Method under test: {@link PasskeyApiController#longToBytes(long)}
   */
  @Test
  void testLongToBytes() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, PasskeyApiController.longToBytes(1L));
  }

  /**
   * Method under test: {@link PasskeyApiController#bytesToLong(byte[])}
   */
  @Test
  void testBytesToLong() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, PasskeyApiController.bytesToLong("AXAXAXAX".getBytes("UTF-8")));
    assertThrows(IllegalArgumentException.class, () -> PasskeyApiController.bytesToLong(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#checkRpIdHash(AuthenticatorData, String)}
   */
  @Test
  void testCheckRpIdHash() throws UnsupportedEncodingException {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();

    // Act and Assert
    assertThrows(ApiException.class, () -> passkeyApiController
        .checkRpIdHash(new AuthenticatorData<>("AXAXAXAX".getBytes("UTF-8"), (byte) 'A', 3L), "42"));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#verifySignature(EC2COSEKey, byte[], byte[])}
   */
  @Test
  void testVerifySignature() throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    byte[] keyId = "AXAXAXAX".getBytes("UTF-8");
    COSEAlgorithmIdentifier algorithm = COSEAlgorithmIdentifier.create(42L);
    ArrayList<COSEKeyOperation> keyOps = new ArrayList<>();
    EC2COSEKey coseKey = new EC2COSEKey(keyId, algorithm, keyOps, Curve.SECP256R1, "AXAXAXAX".getBytes("UTF-8"));

    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ApiException.class,
        () -> passkeyApiController.verifySignature(coseKey, signature, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#verifySignature(EC2COSEKey, byte[], byte[])}
   */
  @Test
  void testVerifySignature2() throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    byte[] keyId = "AXAXAXAX".getBytes("UTF-8");
    ArrayList<COSEKeyOperation> keyOps = new ArrayList<>();
    EC2COSEKey coseKey = new EC2COSEKey(keyId, null, keyOps, Curve.SECP256R1, "AXAXAXAX".getBytes("UTF-8"));

    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ApiException.class,
        () -> passkeyApiController.verifySignature(coseKey, signature, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#verifySignature(EC2COSEKey, byte[], byte[])}
   */
  @Test
  void testVerifySignature3() throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ApiException.class,
        () -> passkeyApiController.verifySignature(null, signature, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link PasskeyApiController#verifySignature(EC2COSEKey, byte[], byte[])}
   */
  @Test
  void testVerifySignature4() throws UnsupportedEncodingException, IllegalArgumentException {
    // Arrange
    PasskeyApiController passkeyApiController = new PasskeyApiController();
    byte[] keyId = "AXAXAXAX".getBytes("UTF-8");
    COSEAlgorithmIdentifier algorithm = COSEAlgorithmIdentifier.create(42L);
    ArrayList<COSEKeyOperation> keyOps = new ArrayList<>();
    byte[] x = "AXAXAXAX".getBytes("UTF-8");
    EC2COSEKey coseKey = new EC2COSEKey(keyId, algorithm, keyOps, Curve.SECP256R1, x, "AXAXAXAX".getBytes("UTF-8"));

    byte[] signature = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ApiException.class,
        () -> passkeyApiController.verifySignature(coseKey, signature, "AXAXAXAX".getBytes("UTF-8")));
  }
}
