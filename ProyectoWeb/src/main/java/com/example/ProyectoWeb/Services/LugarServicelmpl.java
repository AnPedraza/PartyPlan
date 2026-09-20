package com.example.ProyectoWeb.Service.Impl;

import com.example.ProyectoWeb.Entities.Lugar;
import com.example.ProyectoWeb.Repository.lugarRepository;
import com.example.ProyectoWeb.Service.LugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarServiceImpl implements LugarService {

    @Autowired
    private lugarRepository lugarRepo;

    @Override
    public List<Lugar> obtenerTodos() {
        return lugarRepo.findAll();
    }

    @Override
    public Lugar obtenerPorId(Long id) {
        return lugarRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado con ID: " + id));
    }

    @Override
    public List<Lugar> obtenerPorCategoria(String categoria) {
        return lugarRepo.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public Lugar guardar(Lugar lugar) {
        return lugarRepo.save(lugar);
    }

    @Override
    public void eliminar(Long id) {
        lugarRepo.deleteById(id);
    }
}