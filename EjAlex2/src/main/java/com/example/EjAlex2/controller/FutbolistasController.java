package com.example.EjAlex2.controller;

import com.example.EjAlex2.dto.FutbolistaReq;
import com.example.EjAlex2.facadeFutbolista.FacadeFutbolista;
import com.example.EjAlex2.model.Futbolista;
import com.example.EjAlex2.service.ServiceFutbolista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FutbolistasController {

    @Autowired
    FacadeFutbolista facade;

    @GetMapping(value ="futbolista/{idFutbolista}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Futbolista leerFutbolista(@PathVariable("idFutbolista") int idFutbolista){
        return facade.read(idFutbolista);
    }

    @GetMapping(value ="futbolistas",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Futbolista> listarFutbolista(){
        return facade.list();
    }

    @PostMapping(value="futbolista",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Integer crearFutbolista(@RequestBody FutbolistaReq futbolista){
        return facade.create(futbolista);
    }

    @PutMapping(value="futbolista",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Integer actualizarFutbolista(@RequestParam("idFutbolista") int idFutbolista,@RequestBody FutbolistaReq futbolista) {
        return facade.update(idFutbolista, futbolista);
    }

    @DeleteMapping(value = "futbolista", produces=MediaType.APPLICATION_JSON_VALUE)
    public Boolean borrarFutbolista(@RequestParam("idFutbolista") int idFutbolista){
        return facade.delete(idFutbolista);
    }

}
