package de.taimos.dvalin.interconnect.core.spring.test;

/*
 * #%L
 * Dvalin interconnect test library
 * %%
 * Copyright (C) 2016 Taimos GmbH
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

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.taimos.dvalin.interconnect.model.service.ADaemonHandler;


/**
 * @param <H> Daemon handler
 */
public class ADaemonTest<H extends ADaemonHandler> {

    @Autowired
    private BeanFactory beanFactory;

    /**
     * @return Daemon handler
     */
    public final H handler() {
        return (H) this.beanFactory.getBean("requestHandler");
    }

}
