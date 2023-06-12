package com.example.EjAlex2.controller;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.model.Futbolista;
import com.example.EjAlex2.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    ServiceImpl service;

    @GetMapping(value ="Futbolista/{idFutbolista}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Futbolista leerFutbolista(@PathVariable("idFutbolista") int idFutbolista){
        return service.readFutbolista(idFutbolista);
    }

    @GetMapping(value ="Equipo/{idEquipo}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Equipo leerEquipo(@PathVariable("idEquipo") int idEquipo){
        return service.readEquipo(idEquipo);
    }

    @GetMapping(value ="Futbolistas",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Futbolista> listarFutbolista(){
        return service.readFutbolistas();
    }

    @GetMapping(value ="Equipos",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Equipo> listarEquipo(){
        return service.readEquipos();
    }

    @PostMapping(value="Futbolista",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Integer crearFutbolista(@RequestBody Futbolista futbolista){
        return service.createFutbolista(futbolista);
    }

    @PostMapping(value="Equipo",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Integer crearEquipo(@RequestBody Equipo equipo){
        return service.createEquipo(equipo);
    }

    @PutMapping(value="Futbolista",produces=MediaType.TEXT_PLAIN_VALUE)
    public Integer actualizarFutbolista(@RequestParam("idFutbolista") int idFutbolista,@RequestBody Futbolista futbolista) {
        return service.updateFutbolista(idFutbolista, futbolista);
    }
    @PutMapping(value="Equipo",produces=MediaType.TEXT_PLAIN_VALUE)
    public Integer actualizarEquipo(@RequestParam("idEquipo") int idEquipo,@RequestBody Equipo equipo) {
        return service.updateEquipo(idEquipo, equipo);
    }

    @DeleteMapping(value = "Futbolista", produces=MediaType.APPLICATION_JSON_VALUE)
    public Futbolista borrarFutbolista(@RequestParam("idFutbolista") int idFutbolista){
        return service.deleteFutbolista(idFutbolista);
    }

    @DeleteMapping(value = "Equipo", produces=MediaType.APPLICATION_JSON_VALUE)
    public Equipo borrarEquipo(@RequestParam("idEquipo") int idEquipo){
        return service.deleteEquipo(idEquipo);
    }

}
