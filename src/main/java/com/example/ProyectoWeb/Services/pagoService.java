package com.example.ProyectoWeb.Services;

import com.example.ProyectoWeb.Entities.pago;

public interface pagoService {
    pago obtenerPorId(Long id);
    pago obtenerPorReserva(Long idReserva);
    pago registrarPago(pago pago);
    pago actualizarEstado(Long id, String estadoPago);
}
