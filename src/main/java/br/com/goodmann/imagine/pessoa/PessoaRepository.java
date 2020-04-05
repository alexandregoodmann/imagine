package br.com.goodmann.imagine.pessoa;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}
