package com.example.EjAlex2.facadeFutbolista;

import com.example.EjAlex2.dto.FutbolistaMapper;
import com.example.EjAlex2.dto.FutbolistaReq;
import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.model.Futbolista;
import com.example.EjAlex2.service.ServiceEquipo;
import com.example.EjAlex2.service.ServiceFutbolista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacadeFutbolista {

    @Autowired
    ServiceFutbolista serviceFutbolista;
    @Autowired
    ServiceEquipo serviceEquipo;
    @Autowired
    FutbolistaMapper mapper;

    public Integer create(FutbolistaReq element) {
        Equipo e = serviceEquipo.read(element.getEquipo());
        Futbolista entity = mapper.dtoToEntity(element);
        entity.setEquipo(e);
        return serviceFutbolista.create(entity);
    }


    public Futbolista read(Integer id) {
        return serviceFutbolista.read(id);
    }


    public List<Futbolista> list() {
        return serviceFutbolista.list();
    }


    public Integer update(Integer id, FutbolistaReq element) {
        Equipo e = serviceEquipo.read(element.getEquipo());
        Futbolista entity = mapper.dtoToEntity(element);
        entity.setEquipo(e);
        return serviceFutbolista.update(id, entity);
    }


    public Boolean delete(Integer id) {
        return serviceFutbolista.delete(id);
    }


}
