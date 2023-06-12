package com.example.EjAlex2.service;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.model.Futbolista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl implements ServiceI {

    private List<Futbolista> futbolistas = new ArrayList<Futbolista>();
    private Equipo madrid;
    private Equipo barcelona;
    private List<Equipo> equipos = new ArrayList<Equipo>();

    public ServiceImpl(){
        madrid = new Equipo("Real Madrid", "Madrid", new ArrayList<Futbolista>());
        barcelona = new Equipo("Futbol Club Barcelona", "Barcelona", new ArrayList<Futbolista>());
        futbolistas.add(new Futbolista( "Vinicius Jr.", "Brasil", 22, "Real Madrid"));
        futbolistas.add(new Futbolista("Pedri", "España", 20, "Futbol Club Barcelona"));
        madrid.aniadirJugador(futbolistas.get(0));
        barcelona.aniadirJugador(futbolistas.get(1));
        equipos.add(madrid);
        equipos.add(barcelona);
    }


    @Override
    public Integer createFutbolista(Futbolista futbolista) {
        int idEquipo = equipoPorNombre(futbolista.getEquipo());
        futbolistas.add(futbolista);
        equipos.get(idEquipo).aniadirJugador(futbolista);
        return futbolistas.size() -1;
    }

    @Override
    public Futbolista readFutbolista(Integer id) {
        return futbolistas.get(id);
    }

    @Override
    public List<Futbolista> readFutbolistas() {
        return futbolistas;
    }

    @Override
    public Integer updateFutbolista(Integer id, Futbolista futbolista) {
        int aux = -1;
        //guardamos el indice del equipo nuevo para aniadirlo despues de ser modificado
        aux = equipoPorNombre(futbolista.getEquipo());
        //eliminamos al jugador del equipo original
        equipos.remove(equipoPorNombre(futbolistas.get(id).getEquipo()).intValue());
        //modificamos todos los campos del jugador
        futbolistas.get(id).setNombre(futbolista.getNombre());
        futbolistas.get(id).setEdad(futbolista.getEdad());
        futbolistas.get(id).setNacionalidad(futbolista.getNacionalidad());
        futbolistas.get(id).setEquipo(futbolista.getEquipo());

        //aniadimos al jugador en el equipo nuevo si este existe
        if(aux != -1) equipos.get(aux).aniadirJugador(futbolista);
        return id;
    }

    @Override
    public Futbolista deleteFutbolista(Integer id) {
        Futbolista f;
        if((f = futbolistas.get(id)) != null){
            for(Equipo e: equipos){
                if(e.getNombre().equals(f.getEquipo())) e.eliminarJugador(f);
            }
            return futbolistas.remove(id.intValue());
        }
        return null;
    }

    @Override
    public Integer createEquipo(Equipo equipo) {
       equipos.add(equipo);
       return equipos.size() - 1;
    }

    @Override
    public Equipo readEquipo(Integer id) {
        return equipos.get(id);
    }

    @Override
    public List<Equipo> readEquipos() {
        return equipos;
    }

    @Override
    public Integer updateEquipo(Integer id, Equipo equipo) {
        equipos.get(id).setNombre(equipo.getNombre());
        equipos.get(id).setCiudad(equipo.getCiudad());
        return id;
    }

    @Override
    public Equipo deleteEquipo(Integer id) {
        return equipos.remove(id.intValue());
    }

    private Integer equipoPorNombre(String nombre){
        for(int i = 0; i < equipos.size(); ++i){
          if(equipos.get(i).getNombre().equals(nombre)) return i;
        }
        return -1;
    }
}
