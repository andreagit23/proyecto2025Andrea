// src/main/java/com/andreamurillo/api/controller/ProductoController.java
package com.andreamurillo.api.controller;

import com.andreamurillo.api.dto.ProductoRequest;
import com.andreamurillo.api.model.Categoria;
import com.andreamurillo.api.model.Producto;
import com.andreamurillo.api.model.Usuario;
import com.andreamurillo.api.service.CategoriaService;
import com.andreamurillo.api.service.ProductoService;
import com.andreamurillo.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired private ProductoService productoService;
    @Autowired private UsuarioService usuarioService;
    @Autowired private CategoriaService categoriaService;

    @GetMapping
    public List<Producto> listarDisponibles() {
        return productoService.listarDisponibles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{id}")
    public List<Producto> getProductosDelUsuario(@PathVariable Long id) {
        return productoService.findByVendedorId(id);
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody ProductoRequest req) {
        Usuario vendedor = usuarioService.buscarPorId(req.getVendedorId())
                .orElseThrow(() ->
                  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor no existe"));
        Categoria categoria = categoriaService.buscarPorId(req.getCategoriaId())
                .orElseThrow(() ->
                  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoría no existe"));

        Producto p = new Producto();
        p.setNombre(req.getNombre());
        p.setDescripcion(req.getDescripcion());
        p.setPrecio(req.getPrecio());
        p.setPorcentajeDonacion(req.getPorcentajeDonacion());
        p.setImagen(req.getImagen());
        p.setEstado(req.getEstado());
        p.setVendedor(vendedor);
        p.setCategoria(categoria);

        Producto creado = productoService.guardar(p);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(
            @PathVariable Long id,
            @RequestBody ProductoRequest req) {

        Usuario vendedor = usuarioService.buscarPorId(req.getVendedorId())
                .orElseThrow(() ->
                  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vendedor no existe"));
        Categoria categoria = categoriaService.buscarPorId(req.getCategoriaId())
                .orElseThrow(() ->
                  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoría no existe"));

        Producto p = new Producto();
        p.setId(id);
        p.setNombre(req.getNombre());
        p.setDescripcion(req.getDescripcion());
        p.setPrecio(req.getPrecio());
        p.setPorcentajeDonacion(req.getPorcentajeDonacion());
        p.setImagen(req.getImagen());
        p.setEstado(req.getEstado());
        p.setVendedor(vendedor);
        p.setCategoria(categoria);

        Producto actualizado = productoService.guardar(p);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
