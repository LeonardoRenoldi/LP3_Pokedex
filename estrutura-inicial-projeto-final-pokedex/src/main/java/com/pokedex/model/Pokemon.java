package com.pokedex.model;

import com.pokedex.dto.MoveDTO;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Pokemon {

    @Id
    private int id;

    private String name;


    private int weight;


    private int height;


    private List<MoveDTO> moves;

    private boolean deleted;
    private LocalDateTime dateOfDelete;

    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase();
    }
}
