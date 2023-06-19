package com.example.EjAlex2.service;

import com.example.EjAlex2.model.Futbolista;
import com.example.EjAlex2.repositories.FutbolistasR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ServiceFutbolista implements ServiceI<Futbolista> {

    @Autowired
    FutbolistasR r;
    @Override
    public Integer create(Futbolista element) {
        return r.save(element).getId();
    }

    @Override
    public Futbolista read(Integer id) {
        Optional<Futbolista> f = r.findById(id);
        if(f.isPresent()) return f.get();
        return null;
    }

    @Override
    public List<Futbolista> list() {
        return r.findAll();
    }

    @Override
    public Integer update(Integer id, Futbolista element) {
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
