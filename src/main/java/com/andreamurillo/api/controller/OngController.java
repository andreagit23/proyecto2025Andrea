package com.andreamurillo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andreamurillo.api.model.Ong;
import com.andreamurillo.api.service.OngService;

@RestController
@RequestMapping("/api/ongs")
public class OngController {
    @Autowired
    private OngService ongService;

    @GetMapping
    public List<Ong> listarOngs() {
        return ongService.listarOngs();
    }

    @PostMapping
    public ResponseEntity<Ong> crear(@RequestBody Ong ong) {
        return ResponseEntity.ok(ongService.guardar(ong));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ong> actualizar(@PathVariable Long id, @RequestBody Ong ong) {
        ong.setId(id);
        return ResponseEntity.ok(ongService.guardar(ong));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ongService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}