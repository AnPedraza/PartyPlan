package com.example.ProyectoWeb.Controller;

import com.example.ProyectoWeb.Entities.lugar;
import com.example.ProyectoWeb.Services.lugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lugares")
@RequiredArgsConstructor
public class lugarController {

    private final lugarService lugarService;

    @GetMapping
    public List<lugar> obtenerTodos() {
        return lugarService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public lugar obtenerPorId(@PathVariable Long id) {
        return lugarService.obtenerPorId(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<lugar> obtenerPorCategoria(@PathVariable String categoria) {
        return lugarService.obtenerPorCategoria(categoria);
    }

    @PostMapping
    public lugar guardar(@RequestBody lugar lugar) {
        return lugarService.guardar(lugar);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lugarService.eliminar(id);
    }
}