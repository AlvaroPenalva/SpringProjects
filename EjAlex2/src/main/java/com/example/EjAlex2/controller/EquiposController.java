package com.example.EjAlex2.controller;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.service.ServiceEquipo;
import com.example.EjAlex2.service.ServiceI;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquiposController {
    @Autowired
    ServiceEquipo service;

    @GetMapping(value = "equipo/{idEquipo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Devuelve los datos de un equipo")
    @ApiResponse(code = 200, message = "Retorna un JSON que contiene los datos del equipo buscado")
    public Equipo leerEquipo(@ApiParam(value = "Identificador del equipo a mostrar") @PathVariable("idEquipo") int idEquipo) {
        return service.read(idEquipo);
    }

    @GetMapping(value = "equipos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Devuelve una lista de los equipos")
    @ApiResponse(code = 200, message = "Retorna un JSON con la lista de los equipos")
    public List<Equipo> listarEquipo() {
        return service.list();
    }

    @PostMapping(value = "equipo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Crea un nuevo equipo")
    @ApiResponse(code = 200, message = "Retorna un entero con el identificador del equipo creado")
    public Integer createEquipo(@ApiParam(value = "Objeto JSON que contiene los datos de un equipo") @RequestBody Equipo equipo) {
        return service.create(equipo);
    }

    @PutMapping(value = "equipo", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualiza los datos de un equipo")
    @ApiResponse(code = 200, message = "Retorna un entero con el identificador del equipo modificado")
    public Integer actualizarEquipo(@ApiParam(value = "Identificador del equipo a modificar") @RequestParam("idEquipo") int idEquipo, @ApiParam(value = "Objeto JSON que contiene los datos de un equipo") @RequestBody Equipo equipo) {
        return service.update(idEquipo, equipo);
    }

    @DeleteMapping(value = "equipo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Elimina un equipo en base de datos")
    @ApiResponse(code = 200, message = "Retorna un booleano confirmando si se ha eliminado el equipo")
    public Boolean borrarEquipo(@ApiParam(value = "Identificador del equipo a eliminar") @RequestParam("idEquipo") int idEquipo) {
        return service.delete(idEquipo);
    }

}
