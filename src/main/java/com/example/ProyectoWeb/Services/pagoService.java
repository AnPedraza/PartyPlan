package com.example.ProyectoWeb.Services;

import com.example.ProyectoWeb.Entities.pago;

import java.util.List;

public interface pagoService {

    List<pago> obtenerTodos();

    pago obtenerPorId(Long id);

    pago obtenerPorReserva(Long idReserva);

    pago registrarPago(pago pago);

    pago actualizarEstado(Long id, String estadoPago);
}
