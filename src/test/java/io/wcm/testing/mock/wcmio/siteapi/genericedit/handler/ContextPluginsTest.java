/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2023 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.testing.mock.wcmio.siteapi.genericedit.handler;

import static io.wcm.testing.mock.wcmio.siteapi.genericedit.handler.ContextPlugins.WCMIO_SITEAPI_GENERICEDIT_HANDLER;
import static io.wcm.testing.mock.wcmio.sling.ContextPlugins.WCMIO_SLING;
import static org.apache.sling.testing.mock.caconfig.ContextPlugins.CACONFIG;
import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;

import io.wcm.siteapi.genericedit.builder.ValueInspectorService;
import io.wcm.siteapi.genericedit.handler.impl.inspector.LinkValueInspectorService;
import io.wcm.siteapi.genericedit.handler.impl.inspector.MediaValueInspectorService;
import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.testing.mock.aem.junit.AemContextBuilder;

public class ContextPluginsTest {

  @Rule
  public AemContext context = new AemContextBuilder()
      .plugin(CACONFIG)
      .plugin(WCMIO_SLING, WCMIO_SITEAPI_GENERICEDIT_HANDLER).build();

  @Test
  public void testServices() {
    assertEquals(2, Stream.of(context.getServices(ValueInspectorService.class, null))
        .filter(service -> service instanceof LinkValueInspectorService || service instanceof MediaValueInspectorService)
        .count());
  }

}
