package com.pokedex.controller;

import com.pokedex.dto.PokemonDTO;
import com.pokedex.model.Pokemon;
import com.pokedex.repository.PokemonRepository;
import com.pokedex.service.PokemonIntegrationService;
import com.pokedex.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pokemons")
@CrossOrigin(origins = "*")
public class PokemonController {

    private PokemonIntegrationService pokemonIntegrationService;
    private PokemonService pokemonService;

    public PokemonController(PokemonIntegrationService pokemonIntegrationService, PokemonService pokemonService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
        this.pokemonService = pokemonService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Pokemon> findById(@PathVariable("id") int id) {
        // TODO Promover trecho de código para uma Service (PokemonService?)
        return  pokemonService.getPokemonByIdAndAdd(id);



    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Pokemon> findByName(@PathVariable("name") String name) {
        // TODO Find Pokémon by name
        return pokemonService.getPokemonByName(name);
    }

    @DeleteMapping("/deletar/name/{name}")
    public ResponseEntity<Pokemon> deleteByname(@PathVariable("name")String name){

        return pokemonService.deletePokemonByName(name);
    }

}


