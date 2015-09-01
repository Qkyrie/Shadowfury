package com.deswaef.shadowfury.infrastructure.repository;

import com.deswaef.shadowfury.ShadowFury;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShadowFury.class)
@ActiveProfiles("integrationtest")
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RepositoryIntegrationTest {

    @Test
    public void setupCheck() throws Exception {
        //just an empty test, to make sure we can setup the environment with this subclass
    }
}
