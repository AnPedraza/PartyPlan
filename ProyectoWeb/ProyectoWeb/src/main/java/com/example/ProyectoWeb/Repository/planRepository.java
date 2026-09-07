package com.example.ProyectoWeb.Repository;

import com.example.ProyectoWeb.Entities.Plan;
import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    // Filtrar planes por tipo (ej. "CULTURAL" o "NOCTURNO")
    List<Plan> findByTipoIgnoreCase(String tipo);

    // Buscar planes por precio máximo
    List<Plan> findByPrecioLessThanEqual(Double precioMaximo);
}