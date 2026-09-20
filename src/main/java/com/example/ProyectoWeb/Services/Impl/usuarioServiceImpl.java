package com.example.ProyectoWeb.Services.Impl;

import com.example.ProyectoWeb.Entities.usuario;
import com.example.ProyectoWeb.Repository.usuarioRepository;
import com.example.ProyectoWeb.Services.usuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class usuarioServiceImpl implements usuarioService {

    private final usuarioRepository usuarioRepository;

    @Override
    public List<usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
    }

    @Override
    public usuario obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con correo: " + correo));
    }

    @Override
    public usuario guardar(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}