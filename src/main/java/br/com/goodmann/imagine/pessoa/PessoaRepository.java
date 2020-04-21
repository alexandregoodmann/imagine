package br.com.goodmann.imagine.pessoa;

import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, String> {

	public Pessoa findBycpf(String cpf);
}
