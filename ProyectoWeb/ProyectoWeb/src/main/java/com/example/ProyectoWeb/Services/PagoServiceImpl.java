package com.example.ProyectoWeb.Service.Impl;

import com.example.ProyectoWeb.Entities.Pago;
import com.example.ProyectoWeb.Repository.pagoRepository;
import com.example.ProyectoWeb.Service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private pagoRepository pagoRepo;

    @Override
    public Pago obtenerPorReserva(Long idReserva) {
        return pagoRepo.findByReserva_IdReserva(idReserva)
                .orElseThrow(() -> new RuntimeException("No existe pago asociado a la reserva: " + idReserva));
    }

    @Override
    public Pago procesarPago(Pago pago) {
        pago.setFechaPago(LocalDate.now());
        if (pago.getEstadoPago() == null || pago.getEstadoPago().isEmpty()) {
            pago.setEstadoPago("APROBADO");
        }
        return pagoRepo.save(pago);
    }
}