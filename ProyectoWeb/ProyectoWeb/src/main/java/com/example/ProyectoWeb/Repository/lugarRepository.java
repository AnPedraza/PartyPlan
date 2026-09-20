package com.example.ProyectoWeb.repository;
import com.example.ProeycetoWeb.Entities.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Long> {

   
    List<Lugar> findByCategoriaIgnoreCase(String categoria);
}