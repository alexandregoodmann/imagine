package br.com.goodmann.imagine.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goodmann.imagine.core.ValidaCPF;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public String add(Pessoa pessoa) {

		// valida o cpf informado
		if (!ValidaCPF.isCPF(pessoa.getCpf())) {
			throw new RuntimeException("CPF inválido");
		}

		// valida se a pessoa já está cadastrada
		if (this.repo.findBycpf(pessoa.getCpf()) != null) {
			throw new RuntimeException("CPF já está cadastrado");
		}

		return this.repo.save(pessoa).getId();
	}

}
