package com.pokedex.model;

import com.pokedex.dto.MoveDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "pokemon")
@Data
public class Pokemon {

    @Id
    private int id;

    private String name;

    @Column(name = "Weight")
    private int weight;

    @Column(name = "Height")
    private int height;

    @Column(name = "moves")
    private List<MoveDTO> moves;

    private boolean deleted;
    private LocalDateTime dateOfDelete;

    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase();
    }
}
