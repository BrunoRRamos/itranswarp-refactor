package com.itranswarp.web.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import io.netty.channel.DefaultEventLoop;
import io.pebbletemplates.pebble.attributes.methodaccess.BlacklistMethodAccessValidator;
import io.pebbletemplates.pebble.cache.tag.ConcurrentMapTagCache;
import io.pebbletemplates.pebble.error.PebbleException;
import io.pebbletemplates.pebble.extension.ExtensionRegistry;
import io.pebbletemplates.pebble.node.FlushNode;
import io.pebbletemplates.pebble.template.EvaluationContext;
import io.pebbletemplates.pebble.template.EvaluationContextImpl;
import io.pebbletemplates.pebble.template.EvaluationOptions;
import io.pebbletemplates.pebble.template.Hierarchy;
import io.pebbletemplates.pebble.template.PebbleTemplate;
import io.pebbletemplates.pebble.template.PebbleTemplateImpl;
import io.pebbletemplates.pebble.template.ScopeChain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DateTimeFilter.class})
@ExtendWith(SpringExtension.class)
class DateTimeFilterDiffblueTest {
  @Autowired
  private DateTimeFilter dateTimeFilter;

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply() throws PebbleException {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act and Assert
    assertNull(dateTimeFilter.apply("Input", args, self,
        new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
            importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
            new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
        2));
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply2() throws PebbleException {
    // Arrange
    ZonedDateTime atZoneResult = LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC);
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act and Assert
    assertEquals("1970-01-01 00:00:00 Z",
        dateTimeFilter.apply(atZoneResult, args, self,
            new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
                importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
                new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
            2));
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply3() throws PebbleException {
    // Arrange
    LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act
    Object actualApplyResult = dateTimeFilter.apply(atStartOfDayResult, args, self,
        new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
            importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
            new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
        2);

    // Assert
    assertEquals(String.join("", "1970-01-01 00:00:00 ", System.getProperty("user.timezone")), actualApplyResult);
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply4() throws PebbleException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act and Assert
    assertEquals("1970-01-01",
        dateTimeFilter.apply(ofResult, args, self,
            new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
                importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
                new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
            2));
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply5() throws PebbleException {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act and Assert
    assertEquals("00:00:00",
        dateTimeFilter.apply(LocalTime.MIDNIGHT, args, self,
            new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
                importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
                new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
            2));
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply6() throws PebbleException {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act
    Object actualApplyResult = dateTimeFilter.apply(1L, args, self,
        new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
            importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
            new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
        2);

    // Assert
    assertEquals(String.join("", "1969-12-31 21:00:00 ", System.getProperty("user.timezone")), actualApplyResult);
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply7() throws PebbleException {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act and Assert
    assertNull(dateTimeFilter.apply(null, args, self,
        new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
            importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
            new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
        2));
  }

  /**
   * Method under test:
   * {@link DateTimeFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply8() throws PebbleException {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    PebbleTemplateImpl self = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    PebbleTemplateImpl self2 = new PebbleTemplateImpl(null, new FlushNode(2), "Name");

    Locale locale = Locale.getDefault();
    ExtensionRegistry extensionRegistry = new ExtensionRegistry();
    ConcurrentMapTagCache tagCache = new ConcurrentMapTagCache();
    DefaultEventLoop executorService = new DefaultEventLoop();
    ArrayList<PebbleTemplateImpl> importedTemplates = new ArrayList<>();
    HashMap<String, PebbleTemplateImpl> namedImportedTemplates = new HashMap<>();
    ScopeChain scopeChain = new ScopeChain();
    Hierarchy hierarchy = new Hierarchy(new PebbleTemplateImpl(null, new FlushNode(2), "Name"));

    // Act and Assert
    assertNull(dateTimeFilter.apply(0L, args, self,
        new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
            importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
            new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
        2));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DateTimeFilter#getArgumentNames()}
   *   <li>{@link DateTimeFilter#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DateTimeFilter dateTimeFilter = new DateTimeFilter();

    // Act
    List<String> actualArgumentNames = dateTimeFilter.getArgumentNames();

    // Assert
    assertEquals("datetime", dateTimeFilter.getName());
    assertEquals(1, actualArgumentNames.size());
    assertEquals("format", actualArgumentNames.get(0));
  }
}
