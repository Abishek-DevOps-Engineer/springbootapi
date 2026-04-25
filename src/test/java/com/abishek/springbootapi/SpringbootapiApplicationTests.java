package com.abishek.springbootapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class SpringbootapiApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(SpringbootapiApplicationTests.class);
	@Test
	void contextLoads() {
        log.info("Application context loaded successfully");
	}

}
