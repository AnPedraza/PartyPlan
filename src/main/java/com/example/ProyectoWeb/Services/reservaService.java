package com.example.ProyectoWeb.Services;

import com.example.ProyectoWeb.Entities.reserva;

import java.time.LocalDate;
import java.util.List;

public interface reservaService {
    List<reserva> obtenerTodas();
    reserva obtenerPorId(Long id);
    List<reserva> obtenerPorUsuario(Long idUsuario);
    List<reserva> obtenerPorPlanYFecha(Long idPlan, LocalDate fecha);
    List<reserva> obtenerPorEstado(String estado);
    reserva crear(reserva reserva);
    reserva cambiarEstado(Long id, String nuevoEstado);
    void eliminar(Long id);
}
