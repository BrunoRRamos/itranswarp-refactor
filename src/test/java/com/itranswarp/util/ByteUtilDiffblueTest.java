package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class ByteUtilDiffblueTest {
  /**
   * Method under test: {@link ByteUtil#concat(byte[], byte[])}
   */
  @Test
  void testConcat() throws UnsupportedEncodingException {
    // Arrange
    byte[] buf1 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualConcatResult = ByteUtil.concat(buf1, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualConcatResult);
  }

  /**
   * Method under test: {@link ByteUtil#concat(byte[], byte[], byte[])}
   */
  @Test
  void testConcat2() throws UnsupportedEncodingException {
    // Arrange
    byte[] buf1 = "AXAXAXAX".getBytes("UTF-8");
    byte[] buf2 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualConcatResult = ByteUtil.concat(buf1, buf2, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualConcatResult);
  }

  /**
   * Method under test: {@link ByteUtil#toHexString(byte[])}
   */
  @Test
  void testToHexString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", ByteUtil.toHexString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#toHex(byte)}
   */
  @Test
  void testToHex() {
    // Arrange, Act and Assert
    assertEquals("41", ByteUtil.toHex((byte) 'A'));
  }

  /**
   * Method under test: {@link ByteUtil#fromHex(String)}
   */
  @Test
  void testFromHex() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ByteUtil.fromHex("0123456789ABCDEF"));
    assertEquals('B', ByteUtil.fromHex("42"));
  }

  /**
   * Method under test: {@link ByteUtil#fromHexString(String)}
   */
  @Test
  void testFromHexString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ByteUtil.fromHexString("0123456789ABCDEF"));
    assertArrayEquals(new byte[]{1, '#', 'E', 'g', -119, -85, -51, -17}, ByteUtil.fromHexString(RandomUtil.HEX_DIGITS));
    assertThrows(IllegalArgumentException.class, () -> ByteUtil.fromHexString("foo"));
    assertThrows(IllegalArgumentException.class, () -> ByteUtil.fromHexString("foofoo"));
  }

  /**
   * Method under test: {@link ByteUtil#isSha1(String)}
   */
  @Test
  void testIsSha1() {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isSha1("foo"));
    assertTrue(ByteUtil.isSha1("9999999999999999999999999999999999999999"));
  }

  /**
   * Method under test: {@link ByteUtil#isSha256(String)}
   */
  @Test
  void testIsSha256() {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.isSha256("foo"));
    assertTrue(ByteUtil.isSha256("9999999999999999999999999999999999999999999999999999999999999999"));
  }
}
