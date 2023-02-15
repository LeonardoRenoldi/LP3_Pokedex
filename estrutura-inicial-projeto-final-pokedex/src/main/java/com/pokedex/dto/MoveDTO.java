package com.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoveDTO {


    private String name;

}
