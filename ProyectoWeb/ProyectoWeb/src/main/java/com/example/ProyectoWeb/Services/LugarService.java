package com.example.ProyectoWeb.Service;

import com.example.ProyectoWeb.Entities.Lugar;
import java.util.List;

public interface LugarService {
    List<Lugar> obtenerTodos();
    Lugar obtenerPorId(Long id);
    List<Lugar> obtenerPorCategoria(String categoria);
    Lugar guardar(Lugar lugar);
    void eliminar(Long id);
}