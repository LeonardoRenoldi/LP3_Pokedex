package com.pokedex.repository;

import com.pokedex.model.DeleteLog;
import org.springframework.data.repository.CrudRepository;

public interface DeleteRepository extends CrudRepository<DeleteLog,Integer> {


}
