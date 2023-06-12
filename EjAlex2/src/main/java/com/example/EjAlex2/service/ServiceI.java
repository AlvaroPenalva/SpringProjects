package com.example.EjAlex2.service;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.model.Futbolista;

import java.util.List;

public interface ServiceI {

    public Integer createFutbolista(Futbolista futbolista);
    public Futbolista readFutbolista(Integer id);
    public List<Futbolista> readFutbolistas();
    public Integer updateFutbolista(Integer id, Futbolista futbolista);
    public Futbolista deleteFutbolista(Integer id);

    public Integer createEquipo(Equipo equipo);
    public Equipo readEquipo(Integer id);
    public List<Equipo> readEquipos();
    public Integer updateEquipo(Integer id, Equipo equipo);
    public Equipo deleteEquipo(Integer id);
}
