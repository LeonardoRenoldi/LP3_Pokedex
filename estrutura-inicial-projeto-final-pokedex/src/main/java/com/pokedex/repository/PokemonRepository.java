package com.pokedex.repository;

import com.pokedex.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {

    List<Pokemon> findByWeight(double weight);

    List<Pokemon> findByHeight(double weight);

    Optional<Pokemon> findByName(String name);


    List<Pokemon> deleteByName(String name);


    List<Pokemon> findAll();
}
