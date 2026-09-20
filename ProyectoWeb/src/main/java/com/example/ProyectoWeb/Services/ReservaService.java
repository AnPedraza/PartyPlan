package com.example.ProyectoWeb.Service;

import com.example.ProyectoWeb.Entities.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> obtenerTodas();
    Reserva obtenerPorId(Long id);
    List<Reserva> obtenerPorUsuario(Long idUsuario);
    Reserva crearReserva(Reserva reserva);
    Reserva actualizarEstado(Long idReserva, String nuevoEstado);
    void cancelarReserva(Long id);
}