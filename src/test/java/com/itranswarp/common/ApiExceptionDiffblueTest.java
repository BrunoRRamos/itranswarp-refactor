package com.itranswarp.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.itranswarp.enums.ApiError;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ApiException#ApiException(ApiError, String, String)}
   */
  @Test
  void testNewApiException() {
    // Arrange and Act
    ApiException actualApiException = new ApiException(ApiError.PARAMETER_INVALID, "Data", "An error occurred");

    // Assert
    assertEquals("An error occurred", actualApiException.getMessage());
    assertNull(actualApiException.getCause());
    assertEquals(0, actualApiException.getSuppressed().length);
  }

  /**
   * Method under test: {@link ApiException#toMap()}
   */
  @Test
  void testToMap() {
    // Arrange and Act
    Map<String, String> actualToMapResult = (new ApiException(ApiError.PARAMETER_INVALID)).toMap();

    // Assert
    assertEquals(3, actualToMapResult.size());
    assertEquals("PARAMETER_INVALID", actualToMapResult.get("error"));
    assertEquals("PARAMETER_INVALID", actualToMapResult.get("message"));
    assertNull(actualToMapResult.get("data"));
  }

  /**
   * Method under test: {@link ApiException#ApiException(ApiError)}
   */
  @Test
  void testNewApiException2() {
    // Arrange and Act
    ApiException actualApiException = new ApiException(ApiError.PARAMETER_INVALID);

    // Assert
    assertEquals("PARAMETER_INVALID", actualApiException.getLocalizedMessage());
    assertEquals("PARAMETER_INVALID", actualApiException.getMessage());
    assertNull(actualApiException.data);
    assertNull(actualApiException.getCause());
    assertEquals(0, actualApiException.getSuppressed().length);
    assertEquals(ApiError.PARAMETER_INVALID, actualApiException.error);
  }
}
