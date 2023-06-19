package com.example.EjAlex2.service;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.repositories.EquiposR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ServiceEquipo implements ServiceI<Equipo>{

    @Autowired
    EquiposR r;

    @Override
    public Integer create(Equipo element) {
        return r.save(element).getId();
    }

    @Override
    public Equipo read(Integer id) {
        Optional<Equipo> f = r.findById(id);
        if(f.isPresent()) return f.get();
        return null;
    }

    @Override
    public List<Equipo> list() {
        return r.findAll();
    }

    @Override
    public Integer update(Integer id, Equipo element) {
        if(read(id) != null){
            element.setId(id);
            r.save(element);
            return id;
        }
        return -1;
    }

    @Override
    public Boolean delete(Integer id) {
        if(read(id) != null){
            r.deleteById(id);
            return true;
        }
        return false;
    }
}
