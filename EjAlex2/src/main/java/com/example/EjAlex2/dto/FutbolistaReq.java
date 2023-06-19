package com.example.EjAlex2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FutbolistaReq {
    private Integer id;
    private String nombre;
    private String nacionalidad;
    private Integer edad;
    private Integer equipo;
}
