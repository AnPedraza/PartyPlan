package com.example.ProyectoWeb.Service;

import com.example.ProyectoWeb.Entities.Plan;
import java.util.List;

public interface PlanService {
    List<Plan> obtenerTodos();
    Plan obtenerPorId(Long id);
    List<Plan> obtenerPorTipo(String tipo);
    Plan guardar(Plan plan);
    void eliminar(Long id);
}