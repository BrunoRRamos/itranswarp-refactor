package com.itranswarp.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.jupiter.api.Test;

class IOUtilDiffblueTest {
  /**
   * Method under test: {@link IOUtil#copy(InputStream, OutputStream)}
   */
  @Test
  void testCopy() throws IOException {
    // Arrange
    ByteArrayInputStream from = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream resultTo = new ByteArrayOutputStream(1);

    // Act
    IOUtil.copy(from, resultTo);

    // Assert that nothing has changed
    assertEquals(-1, from.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, resultTo.toByteArray());
  }

  /**
   * Method under test: {@link IOUtil#copy(Reader, Writer)}
   */
  @Test
  void testCopy2() throws IOException {
    // Arrange
    StringReader from = new StringReader("foo");
    StringWriter resultTo = new StringWriter();

    // Act
    IOUtil.copy(from, resultTo);

    // Assert
    assertEquals("foo", resultTo.toString());
  }

  /**
   * Method under test: {@link IOUtil#readAsBytes(InputStream)}
   */
  @Test
  void testReadAsBytes() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualReadAsBytesResult = IOUtil.readAsBytes(input);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualReadAsBytesResult);
  }

  /**
   * Method under test: {@link IOUtil#readAsString(InputStream)}
   */
  @Test
  void testReadAsString() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", IOUtil.readAsString(input));
    assertEquals(-1, input.read(new byte[]{}));
  }
}
