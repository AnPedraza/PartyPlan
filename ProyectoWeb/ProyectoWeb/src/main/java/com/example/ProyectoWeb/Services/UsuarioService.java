package com.example.ProyectoWeb.Service;

import com.example.ProyectoWeb.Entities.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario obtenerPorCorreo(String correo);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
}