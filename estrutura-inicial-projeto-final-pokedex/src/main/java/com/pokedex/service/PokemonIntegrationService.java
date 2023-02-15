package com.pokedex.service;

import com.pokedex.dto.PokemonDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonIntegrationService {

    private RestTemplate restTemplate;

    @Value("${pokemon-external-api}")
    private String uri;

    public PokemonIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PokemonDTO findById(int id) {
        String url = generateURLIntegration(id);
        return this.restTemplate.getForObject(url, PokemonDTO.class);
    }

    public PokemonDTO findByWeight(int weight){
        String url = generateURLIntegration(weight);
        return this.restTemplate.getForObject(url, PokemonDTO.class);
    }

    public PokemonDTO findByHeight(int height){
        String url = generateURLIntegration(height);
        return this.restTemplate.getForObject(url, PokemonDTO.class);
    }

    public PokemonDTO findByName(String name) {
        String url = generateURLIntegration(name);
        return this.restTemplate.getForObject(url, PokemonDTO.class);
    }



    private String generateURLIntegration(int id) {
        return this.uri + "/" + id;
    }

    private String generateURLIntegration(String name) {
        return this.uri + "/" + name;

    }


}
