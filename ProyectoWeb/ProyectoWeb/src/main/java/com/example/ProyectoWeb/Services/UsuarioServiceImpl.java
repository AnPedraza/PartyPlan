package com.example.ProyectoWeb.Service.Impl;

import com.example.ProyectoWeb.Entities.Usuario;
import com.example.ProyectoWeb.Repository.usuarioRepository;
import com.example.ProyectoWeb.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private usuarioRepository usuarioRepo;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario obtenerPorCorreo(String correo) {
        return usuarioRepo.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con correo: " + correo));
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepo.deleteById(id);
    }
}