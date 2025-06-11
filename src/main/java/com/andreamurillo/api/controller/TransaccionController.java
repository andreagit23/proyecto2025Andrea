package com.andreamurillo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreamurillo.api.model.Transaccion;
import com.andreamurillo.api.service.TransaccionService;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @GetMapping("/usuario/{usuarioId}")
    public List<Transaccion> listarPorUsuario(@PathVariable Long usuarioId) {
        return transaccionService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Transaccion> crear(@RequestBody Transaccion transaccion) {
        return ResponseEntity.ok(transaccionService.guardar(transaccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> actualizar(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        transaccion.setId(id);
        return ResponseEntity.ok(transaccionService.guardar(transaccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        transaccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
