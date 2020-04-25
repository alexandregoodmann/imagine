package br.com.goodmann.imagine.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.goodmann.imagine.core.ValidaCPF;

@Service
public class PessoaService {

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

	public String updatePartial(Pessoa pessoa) throws NotFoundException {

		if ("".equals(pessoa.getId()) || pessoa.getId() == null) {
			throw new RuntimeException("Você precisa informar o ID pessoa");
		}

		Pessoa target = this.repo.findById(pessoa.getId()).orElseThrow(NotFoundException::new);

		if (pessoa.getCpf() != null) {
			if (!ValidaCPF.isCPF(pessoa.getCpf())) {
				throw new RuntimeException("CPF inválido");
			}
			target.setCpf(pessoa.getCpf());
		}

		if (pessoa.getEmail() != null)
			target.setEmail(pessoa.getEmail());

		if (pessoa.getNome() != null)
			target.setNome(pessoa.getNome());

		if (pessoa.getObs() != null)
			target.setObs(pessoa.getObs());

		if (pessoa.getTelefone() != null)
			target.setTelefone(pessoa.getTelefone());

		return this.repo.save(target).getId();

	}

}
