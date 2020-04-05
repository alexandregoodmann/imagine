package br.com.goodmann.imagine.imagem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagemRepository extends MongoRepository<Imagem, String> {

}
