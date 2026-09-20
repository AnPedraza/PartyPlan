package com.example.ProyectoWeb.Services.Impl;

import com.example.ProyectoWeb.Entities.reserva;
import com.example.ProyectoWeb.Repository.reservaRepository;
import com.example.ProyectoWeb.Services.reservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reservaServiceImpl implements reservaService {

    private final reservaRepository reservaRepository;

    @Override
    public List<reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada con id: " + id));
    }

    @Override
    public List<reserva> obtenerPorUsuario(Long idUsuario) {
        return reservaRepository.findByUsuario_Id(idUsuario);
    }

    @Override
    public List<reserva > obtenerPorPlanYFecha(Long idPlan, LocalDate fecha) {
        return reservaRepository.findByPlan_IdAndFecha(idPlan, fecha);
    }

    @Override
    public List<reserva> obtenerPorEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    @Override
    public reserva crear(reserva reserva) {
        if (reserva.getEstado() == null || reserva.getEstado().isBlank()) {
            reserva.setEstado("PENDIENTE");
        }
        return reservaRepository.save(reserva);
    }

    @Override
    public reserva cambiarEstado(Long id, String nuevoEstado) {
        reserva reserva = obtenerPorId(id);
        reserva.setEstado(nuevoEstado);
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}