package br.com.goodmann.imagine.imagem;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.goodmann.imagine.pessoa.Pessoa;

public interface ImagemRepository extends MongoRepository<Imagem, String> {

	public List<Imagem> findAllByPessoa(Pessoa pessoa);
}
