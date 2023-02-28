package com.pokedex.service;

import com.pokedex.model.Pokemon;
import com.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;


    public Pokemon getPokemon(Integer id){
        //return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " inexistente"));
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isEmpty()) {
            return null;
        }

        return pokemonOptional.get();
    }

    public Pokemon getPokemon(String name){
        //return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " inexistente"));
        Optional<Pokemon> pokemonOptional = pokemonRepository.findByName(name);
        if (pokemonOptional.isEmpty()) {
            return null;
        }

        return pokemonOptional.get();
    }

    public ResponseEntity<Pokemon>getPokemonByName(@PathVariable("name")String name){
       Pokemon pokemonNameDatabase =  getPokemon(name);
       if (pokemonNameDatabase == null){
           RestTemplate restTemplate = new RestTemplate();
           Pokemon pokeApiPokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name, Pokemon.class);
           Pokemon addedPokemonName = addPokeName(pokeApiPokemon);

           return new ResponseEntity<Pokemon>(addedPokemonName, HttpStatus.OK);
       }
       return new ResponseEntity<Pokemon>(pokemonNameDatabase, HttpStatus.OK);
    }

    public ResponseEntity<Pokemon> getPokemonByIdAndAdd(@PathVariable("id")int id){
        Pokemon pokemonDatabase = getPokemon(id);
        if (pokemonDatabase == null) {
            RestTemplate restTemplate = new RestTemplate();
            Pokemon pokeApiPokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + id, Pokemon.class);
            Pokemon addedPokemon = addPokemon(pokeApiPokemon);

            return new ResponseEntity<Pokemon>(addedPokemon, HttpStatus.OK);
        }
        return new ResponseEntity<Pokemon>(pokemonDatabase, HttpStatus.OK);
    }

    public ResponseEntity<Pokemon> deletePokemonByName(@PathVariable("name")String name){
        Pokemon pokemon= pokemonRepository.findByName(name).orElseThrow();
        pokemon.setDeleted(true);
        pokemon.setDateOfDelete(LocalDateTime.now());
            return null;
    }

    public ResponseEntity<Pokemon>findByWeight(@PathVariable("weight")int weight){
        Pokemon pokemon= pokemonRepository.findByWeight(weight).get(weight);
        return null;
    }

    public ResponseEntity<Pokemon>findByHeight(@PathVariable("height")int height){
        Pokemon pokemon= pokemonRepository.findByHeight(height).get(height);
        return null;
    }



    public List<Pokemon> getPokemonByWeight(double weight) {
        return pokemonRepository.findByWeight(weight);
    }

    public List<Pokemon> getPokemonByHeight(double height) {
        return pokemonRepository.findByHeight(height);
    }

    public Pokemon addPokemon(Pokemon pokemon) {
       return pokemonRepository.save(pokemon);
    }

    public Pokemon addPokeName(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public void updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    public void deletePokemon(int id) {
        pokemonRepository.deleteById(id);
    }

    public void deletePokemonName(String name) {
        pokemonRepository.deleteByName(name);
    }

   public List<Pokemon> getAllPokemon() {
       return pokemonRepository.findAll();
   }
}
