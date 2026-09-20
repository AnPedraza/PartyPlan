package com.example.ProyectoWeb.Controller;

import com.example.ProyectoWeb.Entities.pago;
import com.example.ProyectoWeb.Services.pagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class pagoController {

    private final pagoService pagoService;

    @GetMapping("/{id}")
    public pago obtenerPorId(@PathVariable Long id) {
        return pagoService.obtenerPorId(id);
    }

    @GetMapping("/reserva/{idReserva}")
    public pago obtenerPorReserva(@PathVariable Long idReserva) {
        return pagoService.obtenerPorReserva(idReserva);
    }

    @PostMapping
    public pago registrarPago(@RequestBody pago pago) {
        return pagoService.registrarPago(pago);
    }

    @PutMapping("/{id}/estado")
    public pago actualizarEstado(@PathVariable Long id, @RequestBody String estadoPago) {
        return pagoService.actualizarEstado(id, estadoPago);
    }
}