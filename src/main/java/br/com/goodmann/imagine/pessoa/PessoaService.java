package br.com.goodmann.imagine.pessoa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goodmann.imagine.core.ValidaCPF;

@Service
public class PessoaService {

	private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

	@Autowired
	private PessoaRepository repo;

	public String create(Pessoa pessoa) {

		// valida o cpf informado
		if (!ValidaCPF.isCPF(pessoa.getCpf())) {
			throw new RuntimeException("CPF inválido");
		}

		// valida se a pessoa já está cadastrada
		if (this.repo.findBycpf(pessoa.getCpf()) != null) {
			throw new RuntimeException("CPF já está cadastrado");
		}

		return this.repo.insert(pessoa).getId();
	}

	public String update(Pessoa pessoa) {

		if ("".equals(pessoa.getId()) || pessoa.getId() == null) {
			throw new RuntimeException("Você precisa informar o ID pessoa");
		}

		// valida o cpf informado
		if (!ValidaCPF.isCPF(pessoa.getCpf())) {
			throw new RuntimeException("CPF inválido");
		}

		return this.repo.save(pessoa).getId();
	}

}
