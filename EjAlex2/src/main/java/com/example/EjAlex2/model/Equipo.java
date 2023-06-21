package com.example.EjAlex2.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Integer id;
    private String nombre;
    private String ciudad;
}
