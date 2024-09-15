package com.itranswarp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UserDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link User}
   *   <li>{@link User#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("{User: id=0, role=null, email=null, name=null, locakedUntil=0}", (new User()).toString());
  }
}
