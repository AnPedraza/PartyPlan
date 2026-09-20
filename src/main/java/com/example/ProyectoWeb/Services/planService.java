package com.example.ProyectoWeb.Services;

import com.example.ProyectoWeb.Entities.plan;

import java.math.BigDecimal;
import java.util.List;

public interface planService {
    List<plan> obtenerTodos();
    plan obtenerPorId(Long id);
    List<plan> obtenerPorTipo(String tipo);
    List<plan> obtenerPorPrecioMaximo(BigDecimal precioMaximo);
    plan guardar(plan plan);
    void eliminar(Long id);
}