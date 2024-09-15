package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.itranswarp.common.ApiException;
import com.itranswarp.enums.ResourceEncoding;
import org.junit.jupiter.api.Test;

class ResourceDiffblueTest {
  /**
   * Method under test: {@link Resource#decode()}
   */
  @Test
  void testDecode() {
    // Arrange, Act and Assert
    assertThrows(ApiException.class, () -> (new Resource()).decode());
  }

  /**
   * Method under test: {@link Resource#decode()}
   */
  @Test
  void testDecode2() {
    // Arrange
    Resource resource = new Resource();
    resource.content = "foo";
    resource.encoding = ResourceEncoding.BASE64;

    // Act and Assert
    assertArrayEquals(new byte[]{'~', -118}, resource.decode());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Resource}
   */
  @Test
  void testNewResource() {
    // Arrange and Act
    Resource actualResource = new Resource();

    // Assert
    assertNull(actualResource.encoding);
    assertNull(actualResource.content);
    assertNull(actualResource.hash);
    assertEquals(0L, actualResource.createdAt);
    assertEquals(0L, actualResource.id);
    assertEquals(0L, actualResource.updatedAt);
    assertEquals(0L, actualResource.version);
  }
}
