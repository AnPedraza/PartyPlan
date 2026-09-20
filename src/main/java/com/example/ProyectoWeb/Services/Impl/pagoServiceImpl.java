package com.example.ProyectoWeb.Services.Impl;

import com.example.ProyectoWeb.Entities.pago;
import com.example.ProyectoWeb.Repository.pagoRepository;
import com.example.ProyectoWeb.Services.pagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class pagoServiceImpl implements pagoService {

    private final pagoRepository pagoRepository;

    @Override
    public pago obtenerPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado con id: " + id));
    }

    @Override
    public pago obtenerPorReserva(Long idReserva) {
        return pagoRepository.findByReserva_Id(idReserva)
                .orElseThrow(() -> new IllegalArgumentException("No existe pago para la reserva: " + idReserva));
    }

    @Override
    public pago registrarPago(pago pago) {
        if (pago.getFechaPago() == null) {
            pago.setFechaPago(LocalDate.now());
        }
        if (pago.getEstadoPago() == null || pago.getEstadoPago().isBlank()) {
            pago.setEstadoPago("PENDIENTE");
        }
        return pagoRepository.save(pago);
    }

    @Override
    public pago actualizarEstado(Long id, String estadoPago) {
        pago pago = obtenerPorId(id);
        pago.setEstadoPago(estadoPago);
        return pagoRepository.save(pago);
    }
}