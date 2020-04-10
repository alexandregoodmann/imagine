package br.com.goodmann.imagine;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
class ImagineApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(ImagineApplicationTests.class);

	@Test
	void add() throws JsonProcessingException {

		System.out.println("foi-----------------------------------------------------");

		logger.info("info");
		logger.debug("debug");
		logger.error("error");
		logger.trace("trace");

	}

}
