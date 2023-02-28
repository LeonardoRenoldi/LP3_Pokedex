package com.pokedex.repository;

import com.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, Integer> {

    List<Pokemon> findByWeight(double weight);

    List<Pokemon> findByHeight(double weight);

    Optional<Pokemon> findByName(String name);
    @Query("{$and :[{name: ?0},{deleted: false}] }")
    List<Pokemon> deleteByName(String name);


    List<Pokemon> findAll();
}
