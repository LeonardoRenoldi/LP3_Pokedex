package com.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PokemonDTO {


    private int id;
    private String name;

    private int height;

    private int weight;

    private Collection<MoveDTO> moves;

    public void setName(String name) {
        this.name = name.substring(0,1).toUpperCase() +
                name.substring(1).toLowerCase();
    }

}
