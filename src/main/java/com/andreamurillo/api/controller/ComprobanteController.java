package com.andreamurillo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreamurillo.api.model.Comprobante;
import com.andreamurillo.api.service.ComprobanteService;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<Comprobante> obtenerPorProducto(@PathVariable Long productoId) {
        return comprobanteService.buscarPorProductoId(productoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comprobante> crear(@RequestBody Comprobante comprobante) {
        return ResponseEntity.ok(comprobanteService.guardar(comprobante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comprobante> actualizar(@PathVariable Long id, @RequestBody Comprobante comprobante) {
        comprobante.setId(id);
        return ResponseEntity.ok(comprobanteService.guardar(comprobante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        comprobanteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
