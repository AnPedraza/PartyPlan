package com.example.ProyectoWeb.Service.Impl;

import com.example.ProyectoWeb.Entities.Reserva;
import com.example.ProyectoWeb.Repository.reservaRepository;
import com.example.ProyectoWeb.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private reservaRepository reservaRepo;

    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepo.findAll();
    }

    @Override
    public Reserva obtenerPorId(Long id) {
        return reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));
    }

    @Override
    public List<Reserva> obtenerPorUsuario(Long idUsuario) {
        return reservaRepo.findByUsuario_IdUsuario(idUsuario);
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        // Se define el estado inicial por defecto de la reserva
        if (reserva.getEstado() == null || reserva.getEstado().isEmpty()) {
            reserva.setEstado("PENDIENTE");
        }
        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva actualizarEstado(Long idReserva, String nuevoEstado) {
        Reserva reserva = obtenerPorId(idReserva);
        reserva.setEstado(nuevoEstado);
        return reservaRepo.save(reserva);
    }

    @Override
    public void cancelarReserva(Long id) {
        Reserva reserva = obtenerPorId(id);
        reserva.setEstado("CANCELADA");
        reservaRepo.save(reserva);
    }
}