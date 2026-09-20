package com.example.ProyectoWeb.Controller;

import com.example.ProyectoWeb.Entities.reserva;
import com.example.ProyectoWeb.Services.reservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class reservaController {

    private final reservaService reservaService;

    @GetMapping
    public List<reserva> obtenerTodas() {
        return reservaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public reserva obtenerPorId(@PathVariable Long id) {
        return reservaService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<reserva> obtenerPorUsuario(@PathVariable Long idUsuario) {
        return reservaService.obtenerPorUsuario(idUsuario);
    }

    @GetMapping("/plan/{idPlan}/fecha/{fecha}")
    public List<reserva> obtenerPorPlanYFecha(
            @PathVariable Long idPlan,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return reservaService.obtenerPorPlanYFecha(idPlan, fecha);
    }

    @GetMapping("/estado/{estado}")
    public List<reserva> obtenerPorEstado(@PathVariable String estado) {
        return reservaService.obtenerPorEstado(estado);
    }

    @PostMapping
    public reserva crear(@RequestBody reserva reserva) {
        return reservaService.crear(reserva);
    }

    @PutMapping("/{id}/estado")
    public reserva cambiarEstado(@PathVariable Long id, @RequestBody String nuevoEstado) {
        return reservaService.cambiarEstado(id, nuevoEstado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
    }
}