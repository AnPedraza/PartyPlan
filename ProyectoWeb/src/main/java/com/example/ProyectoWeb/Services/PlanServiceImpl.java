package com.example.ProyectoWeb.Service.Impl;

import com.example.ProyectoWeb.Entities.Plan;
import com.example.ProyectoWeb.Repository.planRepository;
import com.example.ProyectoWeb.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private planRepository planRepo;

    @Override
    public List<Plan> obtenerTodos() {
        return planRepo.findAll();
    }

    @Override
    public Plan obtenerPorId(Long id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado con ID: " + id));
    }

    @Override
    public List<Plan> obtenerPorTipo(String tipo) {
        return planRepo.findByTipoIgnoreCase(tipo);
    }

    @Override
    public Plan guardar(Plan plan) {
        return planRepo.save(plan);
    }

    @Override
    public void eliminar(Long id) {
        planRepo.deleteById(id);
    }
}