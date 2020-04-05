package br.com.goodmann.imagine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;

@SpringBootApplication
public class Application {

	/*
	public @Bean MongoClient mongoClient() {
		return new MongoClient();
	}*/

	@Bean
	ObjectMapper mapper() {
		return new ObjectMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
