package com.example.ProyectoWeb.Service;

import com.example.ProyectoWeb.Entities.Pago;

public interface PagoService {
    Pago obtenerPorReserva(Long idReserva);
    Pago procesarPago(Pago pago);
}