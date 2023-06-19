package com.example.EjAlex2.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
@Data
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Integer id;
    private String nombre;
    private String ciudad;
}
