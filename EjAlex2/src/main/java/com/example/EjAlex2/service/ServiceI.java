package com.example.EjAlex2.service;

import com.example.EjAlex2.model.Equipo;
import com.example.EjAlex2.model.Futbolista;

import java.util.List;

public interface ServiceI<T> {

    Integer create(T element);
    T read(Integer id);
    List<T> list();
    Integer update(Integer id, T element);
    Boolean delete(Integer id);

}
