package br.com.goodmann.imagine;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import br.com.goodmann.imagine.pessoa.Pessoa;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImagemTest {

	private static final Logger logger = LoggerFactory.getLogger(ImagemTest.class);

	@Autowired
	private TestRestTemplate rest;

	private String url = "http://localhost:8080/v1/pessoas";

	@Test
	@Order(2)
	public void findByCPFTest() throws IOException {

		logger.info("[TEST] Busca o objeto inserido pelo CPF");

		ResponseEntity<Pessoa> pessoa = this.rest.getForEntity(this.url + "/cpf/60003880206", Pessoa.class);
		logger.info("[TEST][Pessoa]: " + pessoa.getBody());

		// java.nio.file.Path path = Paths.get("/home/osboxes/Downloads/23461233.jpg");
		// byte[] data = Files.readAllBytes(path);

		File file = new File("/home/osboxes/Downloads/23461233.jpg");

		this.url = this.url + "/" + pessoa.getBody().getId() + "/imagens";

		logger.info("[TEST][URL]: " + this.url);

		Object response = this.rest.postForEntity(this.url, file, String.class);

		logger.info("[TEST][RESPONSE]: " + response);

	}

}
