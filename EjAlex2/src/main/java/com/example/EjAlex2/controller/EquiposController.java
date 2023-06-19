package com.example.EjAlex2.controller;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.service.ServiceEquipo;
import com.example.EjAlex2.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EquiposController {
    @Autowired
    ServiceEquipo service;

    @GetMapping(value ="equipo/{idEquipo}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Equipo leerEquipo(@PathVariable("idEquipo") int idEquipo){
        return service.read(idEquipo);
    }

    @GetMapping(value ="equipos",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Equipo> listarEquipo(){
        return service.list();
    }

    @PostMapping(value="equipo",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Integer createEquipo(@RequestBody Equipo equipo){
        return service.create(equipo);
    }

    @PutMapping(value="equipo",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Integer actualizarEquipo(@RequestParam("idEquipo") int idEquipo,@RequestBody Equipo equipo) {
        return service.update(idEquipo, equipo);
    }

    @DeleteMapping(value = "equipo", produces=MediaType.APPLICATION_JSON_VALUE)
    public Boolean borrarEquipo(@RequestParam("idEquipo") int idEquipo){
        return service.delete(idEquipo);
    }

}
