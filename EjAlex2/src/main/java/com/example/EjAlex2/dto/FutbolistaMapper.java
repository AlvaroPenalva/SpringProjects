package com.example.EjAlex2.dto;

import com.example.EjAlex2.model.Futbolista;
import org.springframework.stereotype.Component;
@Component
public class FutbolistaMapper {

    public Futbolista dtoToEntity(FutbolistaReq f){
        Futbolista entity = new Futbolista();
        entity.setNombre(f.getNombre());
        entity.setNacionalidad(f.getNacionalidad());
        entity.setEdad(f.getEdad());
        return entity;
    }

}
