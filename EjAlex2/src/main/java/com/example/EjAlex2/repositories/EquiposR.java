package com.example.EjAlex2.repositories;

import com.example.EjAlex2.model.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquiposR extends CrudRepository<Equipo, Integer> {
    List<Equipo> findAll();
}
