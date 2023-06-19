package com.example.EjAlex2.repositories;

import com.example.EjAlex2.model.Futbolista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FutbolistasR extends CrudRepository<Futbolista, Integer> {
    List<Futbolista> findAll();
}
