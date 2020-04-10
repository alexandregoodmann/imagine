package br.com.goodmann.imagine;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.goodmann.imagine.pessoa.Pessoa;
import br.com.goodmann.imagine.pessoa.PessoaRepository;

@Testable
public class PessoaTest {

	@Autowired
	private PessoaRepository repo;

	@Test
	private void addTest() {
		Pessoa pessoa = new Pessoa();
		this.repo.save(pessoa);

	}
}
