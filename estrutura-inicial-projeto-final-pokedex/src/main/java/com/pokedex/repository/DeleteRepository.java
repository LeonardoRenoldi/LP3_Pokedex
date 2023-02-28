package com.pokedex.repository;

import com.pokedex.model.DeleteLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteRepository extends MongoRepository<DeleteLog,Integer> {


}
