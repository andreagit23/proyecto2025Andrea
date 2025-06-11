package com.andreamurillo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreamurillo.api.model.EstadoProducto;
import com.andreamurillo.api.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByEstado(EstadoProducto estado);
    List<Producto> findByCategoriaNombreContainingIgnoreCase(String nombre);
    List<Producto> findByVendedorId(Long vendedorId);
}
