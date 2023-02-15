package com.pokedex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "deleteLog")
@Data
public class DeleteLog {

    private Integer id;

    private String name;

    private LocalDateTime dateTime;

}
