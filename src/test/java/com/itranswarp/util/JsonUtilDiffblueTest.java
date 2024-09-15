package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itranswarp.bean.setting.Follow;
import com.itranswarp.bean.setting.Snippet;
import com.itranswarp.model.PasskeyAuth;
import com.webauthn4j.data.AttestationConveyancePreference;
import com.webauthn4j.data.AuthenticatorAttachment;
import com.webauthn4j.data.AuthenticatorSelectionCriteria;
import com.webauthn4j.data.PublicKeyCredentialRpEntity;
import com.webauthn4j.data.PublicKeyCredentialType;
import com.webauthn4j.data.PublicKeyCredentialUserEntity;
import com.webauthn4j.data.ResidentKeyRequirement;
import com.webauthn4j.data.UserVerificationRequirement;
import com.webauthn4j.data.attestation.statement.AttestationCertificatePath;
import com.webauthn4j.data.attestation.statement.COSEAlgorithmIdentifier;
import com.webauthn4j.data.attestation.statement.RSAUnique;
import com.webauthn4j.data.attestation.statement.Response;
import com.webauthn4j.data.attestation.statement.TPMAObject;
import com.webauthn4j.data.attestation.statement.TPMAttestationStatement;
import com.webauthn4j.data.attestation.statement.TPMGenerated;
import com.webauthn4j.data.attestation.statement.TPMIAlgHash;
import com.webauthn4j.data.attestation.statement.TPMIAlgPublic;
import com.webauthn4j.data.attestation.statement.TPMISTAttest;
import com.webauthn4j.data.attestation.statement.TPMSAttest;
import com.webauthn4j.data.attestation.statement.TPMSCertifyInfo;
import com.webauthn4j.data.attestation.statement.TPMSClockInfo;
import com.webauthn4j.data.attestation.statement.TPMSRSAParms;
import com.webauthn4j.data.attestation.statement.TPMTHA;
import com.webauthn4j.data.attestation.statement.TPMTPublic;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class JsonUtilDiffblueTest {
  /**
   * Method under test: {@link JsonUtil#writeJsonAsBytes(Object)}
   */
  @Test
  void testWriteJsonAsBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualWriteJsonAsBytesResult = JsonUtil.writeJsonAsBytes(null);

    // Assert
    assertArrayEquals("null".getBytes("UTF-8"), actualWriteJsonAsBytesResult);
  }

  /**
   * Method under test: {@link JsonUtil#writeJsonAsBytes(Object)}
   */
  @Test
  void testWriteJsonAsBytes2() throws UnsupportedEncodingException {
    // Arrange
    COSEAlgorithmIdentifier alg = COSEAlgorithmIdentifier.create(42L);
    AttestationCertificatePath x5c = new AttestationCertificatePath();
    byte[] sig = "AXAXAXAX".getBytes("UTF-8");
    byte[] qualifiedSigner = "AXAXAXAX".getBytes("UTF-8");
    byte[] extraData = "AXAXAXAX".getBytes("UTF-8");
    TPMSClockInfo clockInfo = new TPMSClockInfo(BigInteger.valueOf(1L), 3L, 3L, true);

    BigInteger firmwareVersion = BigInteger.valueOf(1L);
    TPMTHA name = new TPMTHA(TPMIAlgHash.TPM_ALG_ERROR, "AXAXAXAX".getBytes("UTF-8"));

    TPMSAttest certInfo = new TPMSAttest(TPMGenerated.TPM_GENERATED_VALUE, TPMISTAttest.TPM_ST_ATTEST_CERTIFY,
        qualifiedSigner, extraData, clockInfo, firmwareVersion,
        new TPMSCertifyInfo(name, new TPMTHA(TPMIAlgHash.TPM_ALG_ERROR, "AXAXAXAX".getBytes("UTF-8"))));

    TPMAObject objectAttributes = new TPMAObject(42);
    byte[] authPolicy = "AXAXAXAX".getBytes("UTF-8");
    byte[] symmetric = "AXAXAXAX".getBytes("UTF-8");
    byte[] scheme = "AXAXAXAX".getBytes("UTF-8");
    byte[] keyBits = "AXAXAXAX".getBytes("UTF-8");
    TPMSRSAParms parameters = new TPMSRSAParms(symmetric, scheme, keyBits, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonUtil.writeJsonAsBytes(new TPMAttestationStatement(alg, x5c, sig, certInfo,
            new TPMTPublic(TPMIAlgPublic.TPM_ALG_ERROR, TPMIAlgHash.TPM_ALG_ERROR, objectAttributes, authPolicy,
                parameters, new RSAUnique("AXAXAXAX".getBytes("UTF-8"))))));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(OutputStream, Object)}
   */
  @Test
  void testWriteJson() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    JsonUtil.writeJson(output, "Obj");

    // Assert
    byte[] expectedToByteArrayResult = "\"Obj\"".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(OutputStream, Object)}
   */
  @Test
  void testWriteJson2() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    JsonUtil.writeJson(output, null);

    // Assert
    byte[] expectedToByteArrayResult = "null".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(OutputStream, Object)}
   */
  @Test
  void testWriteJson3() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(0);

    // Act
    JsonUtil.writeJson(output, "Obj");

    // Assert
    byte[] expectedToByteArrayResult = "\"Obj\"".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(OutputStream, Object)}
   */
  @Test
  void testWriteJson4() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    JsonUtil.writeJson(output, 19088743);

    // Assert
    byte[] expectedToByteArrayResult = "19088743".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson5() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"facebook\":null,\"github\":null,\"instagram\":null,\"linkedin\":null,\"reddit\":null,\"twitter\":null,\"weibo\""
            + ":null,\"youtube\":null,\"follows\":[]}",
        JsonUtil.writeJson(new Follow()));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson6() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"indexTop\":null,\"indexBottom\":null,\"bodyTop\":null,\"bodyBottom\":null,\"contentTop\":null,\"contentBottom"
            + "\":null,\"sidebarLeftTop\":null,\"sidebarLeftBottom\":null,\"sidebarRightTop\":null,\"sidebarRightBottom\""
            + ":null}",
        JsonUtil.writeJson(new Snippet()));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson7() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"id\":0,\"createdAt\":0,\"updatedAt\":0,\"version\":0,\"userId\":0,\"credentialId\":null,\"device\":null,\"alg\":0"
            + ",\"transports\":null}",
        JsonUtil.writeJson(new PasskeyAuth()));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson8() {
    // Arrange, Act and Assert
    assertEquals("null", JsonUtil.writeJson(null));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson9() {
    // Arrange, Act and Assert
    assertEquals("\"42\"", JsonUtil.writeJson(AttestationConveyancePreference.create("42")));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson10() {
    // Arrange
    AuthenticatorAttachment authenticatorAttachment = AuthenticatorAttachment.create("42");
    ResidentKeyRequirement residentKey = ResidentKeyRequirement.create("42");

    // Act and Assert
    assertEquals(
        "{\"authenticatorAttachment\":\"42\",\"requireResidentKey\":false,\"residentKey\":\"42\",\"userVerification"
            + "\":\"42\"}",
        JsonUtil.writeJson(new AuthenticatorSelectionCriteria(authenticatorAttachment, residentKey,
            UserVerificationRequirement.create("42"))));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson11() {
    // Arrange, Act and Assert
    assertEquals("{\"id\":null,\"name\":\"Name\"}", JsonUtil.writeJson(new PublicKeyCredentialRpEntity("Name")));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson12() {
    // Arrange, Act and Assert
    assertEquals("\"42\"", JsonUtil.writeJson(PublicKeyCredentialType.create("42")));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson13() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("{\"id\":\"QVhBWEFYQVg=\",\"name\":\"Name\",\"displayName\":\"Display Name\"}",
        JsonUtil.writeJson(new PublicKeyCredentialUserEntity("AXAXAXAX".getBytes("UTF-8"), "Name", "Display Name")));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson14() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"nonce\":\"Nonce\",\"timestampMs\":10,\"apkPackageName\":\"java.text\",\"apkCertificateDigestSha256\":[\"Apk"
            + " Certificate Digest Sha256\"],\"apkDigestSha256\":\"Apk Digest Sha256\",\"ctsProfileMatch\":true,\"basicIntegrity"
            + "\":true,\"advice\":\"Advice\",\"error\":null}",
        JsonUtil.writeJson(new Response("Nonce", 10L, "java.text", new String[]{"Apk Certificate Digest Sha256"},
            "Apk Digest Sha256", true, true, "Advice")));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson15() throws UnsupportedEncodingException {
    // Arrange
    COSEAlgorithmIdentifier alg = COSEAlgorithmIdentifier.create(42L);
    AttestationCertificatePath x5c = new AttestationCertificatePath();
    byte[] sig = "AXAXAXAX".getBytes("UTF-8");
    byte[] qualifiedSigner = "AXAXAXAX".getBytes("UTF-8");
    byte[] extraData = "AXAXAXAX".getBytes("UTF-8");
    TPMSClockInfo clockInfo = new TPMSClockInfo(BigInteger.valueOf(1L), 3L, 3L, true);

    BigInteger firmwareVersion = BigInteger.valueOf(1L);
    TPMTHA name = new TPMTHA(TPMIAlgHash.TPM_ALG_ERROR, "AXAXAXAX".getBytes("UTF-8"));

    TPMSAttest certInfo = new TPMSAttest(TPMGenerated.TPM_GENERATED_VALUE, TPMISTAttest.TPM_ST_ATTEST_CERTIFY,
        qualifiedSigner, extraData, clockInfo, firmwareVersion,
        new TPMSCertifyInfo(name, new TPMTHA(TPMIAlgHash.TPM_ALG_ERROR, "AXAXAXAX".getBytes("UTF-8"))));

    TPMAObject objectAttributes = new TPMAObject(42);
    byte[] authPolicy = "AXAXAXAX".getBytes("UTF-8");
    byte[] symmetric = "AXAXAXAX".getBytes("UTF-8");
    byte[] scheme = "AXAXAXAX".getBytes("UTF-8");
    byte[] keyBits = "AXAXAXAX".getBytes("UTF-8");
    TPMSRSAParms parameters = new TPMSRSAParms(symmetric, scheme, keyBits, "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonUtil.writeJson(new TPMAttestationStatement(alg, x5c, sig, certInfo,
            new TPMTPublic(TPMIAlgPublic.TPM_ALG_ERROR, TPMIAlgHash.TPM_ALG_ERROR, objectAttributes, authPolicy,
                parameters, new RSAUnique("AXAXAXAX".getBytes("UTF-8"))))));
  }

  /**
   * Method under test: {@link JsonUtil#writeJson(Object)}
   */
  @Test
  void testWriteJson16() {
    // Arrange, Act and Assert
    assertEquals("19088743", JsonUtil.writeJson(19088743));
  }

  /**
   * Method under test: {@link JsonUtil#writeJsonWithPrettyPrint(Object)}
   */
  @Test
  void testWriteJsonWithPrettyPrint() {
    // Arrange, Act and Assert
    assertEquals("\"Obj\"", JsonUtil.writeJsonWithPrettyPrint("Obj"));
    assertEquals("null", JsonUtil.writeJsonWithPrettyPrint(null));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(Reader, Class)}
   */
  @Test
  void testReadJson() {
    // Arrange
    StringReader reader = new StringReader("foo");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(reader, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(Reader, Class)}
   */
  @Test
  void testReadJson2() {
    // Arrange
    StringReader reader = new StringReader("");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(reader, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(Reader, Class)}
   */
  @Test
  void testReadJson3() {
    // Arrange
    CharArrayReader reader = new CharArrayReader("A\u0000A\u0000".toCharArray(), 1, 1);

    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(reader, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(Reader, Class)}
   */
  @Test
  void testReadJson4() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<JsonUtil> clazz = JsonUtil.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(reader, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(Reader, Class)}
   */
  @Test
  void testReadJson5() {
    // Arrange
    StringReader reader = new StringReader("42");
    Class<Map> clazz = Map.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(reader, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(String, Class)}
   */
  @Test
  void testReadJson6() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson("Str", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(String, Class)}
   */
  @Test
  void testReadJson7() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson("", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(String, Class)}
   */
  @Test
  void testReadJson8() {
    // Arrange
    Class<JsonUtil> clazz = JsonUtil.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson("Str", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(String, Class)}
   */
  @Test
  void testReadJson9() {
    // Arrange
    Class<JsonUtil> clazz = JsonUtil.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson("42", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(String, Class)}
   */
  @Test
  void testReadJson10() {
    // Arrange
    Class<Map> clazz = Map.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson("42", clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(byte[], Class)}
   */
  @Test
  void testReadJson11() throws UnsupportedEncodingException {
    // Arrange
    byte[] src = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(src, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(byte[], Class)}
   */
  @Test
  void testReadJson12() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonUtil.readJson(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(byte[], Class)}
   */
  @Test
  void testReadJson13() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(new byte[]{}, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJson(byte[], Class)}
   */
  @Test
  void testReadJson14() throws UnsupportedEncodingException {
    // Arrange
    byte[] src = "AXAXAXAX".getBytes("UTF-8");
    Class<JsonUtil> clazz = JsonUtil.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJson(src, clazz));
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap() throws JsonProcessingException {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();

    // Act
    Map<String, Object> actualReadJsonAsMapResult = JsonUtil
        .readJsonAsMap(objectMapper.writeValueAsString(new HashMap<>()));

    // Assert
    assertTrue(actualReadJsonAsMapResult.isEmpty());
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap2() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJsonAsMap("Str"));
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap3() throws JsonProcessingException {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", "42");

    // Act
    Map<String, Object> actualReadJsonAsMapResult = JsonUtil
        .readJsonAsMap((new ObjectMapper()).writeValueAsString(objectObjectMap));

    // Assert
    assertEquals(1, actualReadJsonAsMapResult.size());
    assertEquals("42", actualReadJsonAsMapResult.get("42"));
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap4() throws JsonProcessingException {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", new HashMap<>());

    // Act
    Map<String, Object> actualReadJsonAsMapResult = JsonUtil
        .readJsonAsMap((new ObjectMapper()).writeValueAsString(objectObjectMap));

    // Assert
    assertEquals(objectObjectMap, actualReadJsonAsMapResult);
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap5() throws JsonProcessingException {
    // Arrange
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put("42", null);

    // Act
    Map<String, Object> actualReadJsonAsMapResult = JsonUtil
        .readJsonAsMap((new ObjectMapper()).writeValueAsString(objectObjectMap));

    // Assert
    assertEquals(1, actualReadJsonAsMapResult.size());
    assertNull(actualReadJsonAsMapResult.get("42"));
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap6() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJsonAsMap("42"));
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap7() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJsonAsMap(""));
  }

  /**
   * Method under test: {@link JsonUtil#readJsonAsMap(String)}
   */
  @Test
  void testReadJsonAsMap8() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonUtil.readJsonAsMap("42Str"));
  }
}
