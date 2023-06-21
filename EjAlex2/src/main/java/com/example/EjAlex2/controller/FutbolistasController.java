package com.example.EjAlex2.controller;

import com.example.EjAlex2.dto.FutbolistaReq;
import com.example.EjAlex2.facadeFutbolista.FacadeFutbolista;
import com.example.EjAlex2.model.Futbolista;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FutbolistasController {

    @Autowired
    FacadeFutbolista facade;

    @GetMapping(value = "futbolista/{idFutbolista}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Muestra los datos de un futbolista")
    @ApiResponse(code = 200, message = "Retorna un json con los datos del futbolista incluido el equipo al que pertenece")
    public Futbolista leerFutbolista(@ApiParam(value = "Identificador del futbolista a mostrar") @PathVariable("idFutbolista") int idFutbolista) {
        return facade.read(idFutbolista);
    }

    @GetMapping(value = "futbolistas", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos los futbolistas")
    @ApiResponse(code = 200, message = "Retorna una lista json con los datos de los futbolistas")
    public List<Futbolista> listarFutbolista() {
        return facade.list();
    }

    @PostMapping(value = "futbolista", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Crea un nuevo futbolista")
    @ApiResponse(code = 200, message = "Retorna un entero con el identificador del futbolista creado")
    public Integer crearFutbolista(@ApiParam(value = "Objeto JSON que contiene los datos de un futbolista") @RequestBody FutbolistaReq futbolista) {
        return facade.create(futbolista);
    }

    @PutMapping(value = "futbolista", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Actualiza los datos de un futbolista")
    @ApiResponse(code = 200, message = "Retorna un entero con el id del futbolista modificado")
    public Integer actualizarFutbolista(@ApiParam(value = "Numero identificador del futbolista a modificar") @RequestParam("idFutbolista") int idFutbolista, @ApiParam(value = "Objeto JSON que contiene los datos de un futbolista") @RequestBody FutbolistaReq futbolista) {
        return facade.update(idFutbolista, futbolista);
    }

    @DeleteMapping(value = "futbolista", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Borra un futbolista de base de datos")
    @ApiResponse(code = 200, message = "Retorna un booleano con la confirmación de si se ha eliminado o no el futbolista")
    public Boolean borrarFutbolista(@ApiParam(value = "Identificador del futbolista a eliminar") @RequestParam("idFutbolista") int idFutbolista) {
        return facade.delete(idFutbolista);
    }

}
