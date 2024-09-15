package com.itranswarp.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.lionsoul.jcseg.dic.ADictionary;
import org.lionsoul.jcseg.segmenter.SegmenterConfig;

class AbstractSearcherDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractSearcher#createCustomizedDictionary(SegmenterConfig, boolean, boolean)}
   */
  @Test
  void testCreateCustomizedDictionary() {
    // Arrange
    SegmenterConfig config = new SegmenterConfig("Pro File");

    // Act
    ADictionary actualCreateCustomizedDictionaryResult = AbstractSearcher.createCustomizedDictionary(config, true,
        true);

    // Assert
    assertEquals(5, actualCreateCustomizedDictionaryResult.mixPrefixLength);
    assertEquals(5, actualCreateCustomizedDictionaryResult.mixSuffixLength);
    assertTrue(actualCreateCustomizedDictionaryResult.isSync());
    assertSame(config, actualCreateCustomizedDictionaryResult.getConfig());
  }

  /**
   * Method under test: {@link AbstractSearcher#ready()}
   */
  @Test
  void testReady() {
    // Arrange, Act and Assert
    assertFalse((new RedisSearcher()).ready());
  }

  /**
   * Method under test: {@link AbstractSearcher#parseQuery(String)}
   */
  @Test
  void testParseQuery() throws IOException {
    // Arrange, Act and Assert
    assertNull((new RedisSearcher()).parseQuery("foo"));
  }

  /**
   * Method under test: {@link AbstractSearcher#search(List, int)}
   */
  @Test
  void testSearch() throws Exception {
    // Arrange
    RedisSearcher redisSearcher = new RedisSearcher();

    // Act
    Hits actualSearchResult = redisSearcher.search(new ArrayList<>(), 3);

    // Assert
    assertEquals(0, actualSearchResult.total);
    assertTrue(actualSearchResult.documents.isEmpty());
  }

  /**
   * Method under test: {@link AbstractSearcher#search(List, int)}
   */
  @Test
  void testSearch2() throws Exception {
    // Arrange
    RedisSearcher redisSearcher = new RedisSearcher();

    ArrayList<String> qs = new ArrayList<>();
    qs.add("foo");

    // Act
    Hits actualSearchResult = redisSearcher.search(qs, 3);

    // Assert
    assertEquals(0, actualSearchResult.total);
    assertTrue(actualSearchResult.documents.isEmpty());
  }

  /**
   * Method under test: {@link AbstractSearcher#search(List, int)}
   */
  @Test
  void testSearch3() throws Exception {
    // Arrange
    RedisSearcher redisSearcher = new RedisSearcher();

    ArrayList<String> qs = new ArrayList<>();
    qs.add("42");
    qs.add("foo");

    // Act
    Hits actualSearchResult = redisSearcher.search(qs, 3);

    // Assert
    assertEquals(0, actualSearchResult.total);
    assertTrue(actualSearchResult.documents.isEmpty());
  }
}
