package de.taimos.dvalin.interconnect.demo;


import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.taimos.daemon.log4j.Log4jLoggingConfigurer;
import de.taimos.daemon.spring.SpringDaemonTestRunner;
import de.taimos.daemon.spring.SpringDaemonTestRunner.RunnerConfiguration;
import de.taimos.dvalin.interconnect.core.spring.test.ADaemonTest;
import de.taimos.dvalin.interconnect.demo.model.UserIVO_v1;
import de.taimos.dvalin.interconnect.demo.model.requests.CreateUserIVO_v1;
import de.taimos.dvalin.interconnect.demo.model.requests.FindUserIVO_v1;
import de.taimos.dvalin.interconnect.model.ivo.util.IVOQueryResultIVO_v1;
import de.taimos.dvalin.interconnect.model.service.DaemonError;


@RunWith(SpringDaemonTestRunner.class)
@RunnerConfiguration(svc = "user-service", loggingConfigurer = Log4jLoggingConfigurer.class, config = TestConfig.class)
public class HandlerTest extends ADaemonTest<Handler> {

    @Test
    public void testUserlist() throws DaemonError {
        IVOQueryResultIVO_v1<UserIVO_v1> users = handler().findUsers(new FindUserIVO_v1.FindUserIVO_v1Builder().build());
        Assert.assertEquals(0, users.getElements().size());
    }

    @Test
    public void testCreateUser() throws DaemonError {
        String name = UUID.randomUUID().toString();

        UserIVO_v1.UserIVO_v1Builder uB = new UserIVO_v1.UserIVO_v1Builder();
        uB.withName(name);

        CreateUserIVO_v1.CreateUserIVO_v1Builder b = new CreateUserIVO_v1.CreateUserIVO_v1Builder();
        b.withValue(uB.build());
        UserIVO_v1 user = handler().createUser(b.build());

        Assert.assertEquals(name, user.getName());
    }

}
