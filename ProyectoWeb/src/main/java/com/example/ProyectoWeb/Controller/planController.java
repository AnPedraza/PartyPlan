package com.example.ProyectoWeb.Controller;

import com.example.ProyectoWeb.Entities.plan;
import com.example.ProyectoWeb.Services.planService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
public class planController {

    private final planService planService;

    @GetMapping
    public List<plan> obtenerTodos() {
        return planService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public plan obtenerPorId(@PathVariable Long id) {
        return planService.obtenerPorId(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<plan> obtenerPorTipo(@PathVariable String tipo) {
        return planService.obtenerPorTipo(tipo);
    }

    @GetMapping("/precio-maximo/{precioMaximo}")
    public List<plan> obtenerPorPrecioMaximo(@PathVariable BigDecimal precioMaximo) {
        return planService.obtenerPorPrecioMaximo(precioMaximo);
    }

    @PostMapping
    public plan guardar(@RequestBody plan plan) {
        return planService.guardar(plan);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        planService.eliminar(id);
    }
}