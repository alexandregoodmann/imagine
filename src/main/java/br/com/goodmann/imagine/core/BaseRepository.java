package br.com.goodmann.imagine.core;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseModel, ID> extends MongoRepository<T, ID> {

}
