package de.taimos.dvalin.interconnect.demo;

/*
 * #%L
 * Dvalin interconnect demo project
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

import de.taimos.daemon.spring.SpringDaemonTestRunner;

/**
 * Created by thoeger on 17.01.16.
 */
public class TestConfig extends SpringDaemonTestRunner.RunnerConfig {

    @Override
    public String getServicePackage() {
        return TestConfig.class.getPackage().getName();
    }

    @Override
    public String getSpringFile() {
        return "spring/beans.xml";
    }
}
