package com.andreamurillo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreamurillo.api.model.Monedero;
import com.andreamurillo.api.service.MonederoService;

@RestController
@RequestMapping("/api/monederos")
public class MonederoController {
    @Autowired
    private MonederoService monederoService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Monedero> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return monederoService.buscarPorUsuarioId(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Monedero> crear(@RequestBody Monedero monedero) {
        return ResponseEntity.ok(monederoService.guardar(monedero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monedero> actualizar(@PathVariable Long id, @RequestBody Monedero monedero) {
        monedero.setId(id);
        return ResponseEntity.ok(monederoService.guardar(monedero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        monederoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}