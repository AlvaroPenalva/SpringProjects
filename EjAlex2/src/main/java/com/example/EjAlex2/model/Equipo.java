package com.example.EjAlex2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    private String nombre;
    private String ciudad;
    private ArrayList<Futbolista> jugadores;

    public void aniadirJugador(Futbolista f){
        jugadores.add(f);
    }
    public void eliminarJugador(Futbolista f){
        for(int i = 0; i < jugadores.size(); ++i){
            if(jugadores.get(i).getNombre().equals(f.getNombre())) jugadores.remove(i);
        }
    }
}
