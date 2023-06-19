package com.example.EjAlex2.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "futbolistas")
public class Futbolista {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_futbolista")
    private Integer id;
    private String nombre;
    private String nacionalidad;
    private Integer edad;
    @ManyToOne
    @JoinColumn(name = "equipo", referencedColumnName = "id_equipo", updatable = true, insertable = true)
    private Equipo equipo;
}
