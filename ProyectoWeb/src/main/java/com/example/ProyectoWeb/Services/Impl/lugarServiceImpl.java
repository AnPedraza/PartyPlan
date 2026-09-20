package com.example.ProyectoWeb.Services.Impl;

import com.example.ProyectoWeb.Entities.lugar;
import com.example.ProyectoWeb.Repository.lugarRepository;
import com.example.ProyectoWeb.Services.lugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class lugarServiceImpl implements lugarService {

    private final lugarRepository lugarRepository;

    @Override
    public List<lugar> obtenerTodos() {
        return lugarRepository.findAll();
    }

    @Override
    public lugar obtenerPorId(Long id) {
        return lugarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lugar no encontrado con id: " + id));
    }

    @Override
    public List<lugar> obtenerPorCategoria(String categoria) {
        return lugarRepository.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public lugar guardar(lugar lugar) {
        return lugarRepository.save(lugar);
    }

    @Override
    public void eliminar(Long id) {
        lugarRepository.deleteById(id);
    }
}