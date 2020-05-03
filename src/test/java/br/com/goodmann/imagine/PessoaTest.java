package br.com.goodmann.imagine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.goodmann.imagine.pessoa.Pessoa;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // need this in Spring Boot test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaTest {

	private static final Logger logger = LoggerFactory.getLogger(PessoaTest.class);

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate rest;

	private String url = "http://localhost:8080/v1/pessoas";

	@Test
	@Order(1)
	public void createTest() {

		logger.info("[TEST] Cria e salva em banco de dados objeto pessoa");

		Pessoa p = new Pessoa();
		p.setNome("Alexandre Ferreira");
		p.setEmail("alexndregoodmann@gmail.com");
		p.setCpf("60003880206");
		p.setTelefone("51981204068");

		ResponseEntity<String> response = this.rest.postForEntity(this.url, p, String.class);

		logger.info("[TEST][RESPONSE]: " + response.getBody());

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	@Order(2)
	public void findByCPFTest() {

		logger.info("[TEST] Busca o objeto inserido pelo CPF");

		ResponseEntity<Pessoa> response = this.rest.getForEntity(this.url + "/cpf/60003880206", Pessoa.class);

		logger.info("[TEST][RESPONSE]: " + response);

		assertNotNull(response.getBody().getId());
	}

	@Test
	@Order(3)
	public void findTest() {

		logger.info("[TEST] Faz busca pelo CPF, depois busca pelo ID");

		ResponseEntity<Pessoa> response1 = this.rest.getForEntity(this.url + "/cpf/60003880206", Pessoa.class);
		ResponseEntity<Pessoa> response2 = this.rest.getForEntity(this.url + "/" + response1.getBody().getId(),
				Pessoa.class);

		logger.info("[TEST][RESPONSE]: " + response2);

		assertNotNull(response2.getBody().getId());
	}

	@Test
	@Order(4)
	public void deleteTest() {

		logger.info("[TEST] Deleta o objeto inserido. Busca pelo CPF e deleta. Depois busca novamente para confirmar.");

		ResponseEntity<Pessoa> response1 = this.rest.getForEntity(this.url + "/cpf/60003880206", Pessoa.class);

		this.rest.delete(this.url + "/" + response1.getBody().getId());

		ResponseEntity<Pessoa> response2 = this.rest.getForEntity(this.url + "/cpf/60003880206", Pessoa.class);

		assertNull(response2.getBody());
	}

}
