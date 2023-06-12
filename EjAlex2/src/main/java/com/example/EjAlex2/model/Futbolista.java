package com.example.EjAlex2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Futbolista {
    private String nombre;
    private String nacionalidad;
    private Integer edad;
    private String equipo;
}
