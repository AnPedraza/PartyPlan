package com.example.ProyectoWeb.Services;

import com.example.ProyectoWeb.Entities.usuario;
import java.util.List;

public interface usuarioService {
    List<usuario> obtenerTodos();
    usuario obtenerPorId(Long id);
    usuario obtenerPorCorreo(String correo);
    usuario guardar(usuario usuario);
    void eliminar(Long id);
}