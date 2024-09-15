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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JoinFilter.class})
@ExtendWith(SpringExtension.class)
class JoinFilterDiffblueTest {
  @Autowired
  private JoinFilter joinFilter;

  /**
   * Method under test: {@link JoinFilter#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("join", (new JoinFilter()).getName());
  }

  /**
   * Method under test:
   * {@link JoinFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply() throws PebbleException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
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
    assertEquals("",
        joinFilter.apply(objectList, args, self,
            new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
                importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
                new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
            2));
  }

  /**
   * Method under test:
   * {@link JoinFilter#apply(Object, Map, PebbleTemplate, EvaluationContext, int)}
   */
  @Test
  void testApply2() throws PebbleException {
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
    assertNull(joinFilter.apply(null, args, self,
        new EvaluationContextImpl(self2, true, locale, 3, extensionRegistry, tagCache, executorService,
            importedTemplates, namedImportedTemplates, scopeChain, hierarchy,
            new EvaluationOptions(true, new BlacklistMethodAccessValidator())),
        2));
  }
}
