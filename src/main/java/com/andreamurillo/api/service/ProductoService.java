package com.andreamurillo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.EstadoProducto;
import com.andreamurillo.api.model.Producto;
import com.andreamurillo.api.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarDisponibles() {
        return productoRepository.findByEstado(EstadoProducto.DISPONIBLE);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizar(Long id, Producto nuevoProducto) {
        nuevoProducto.setId(id);
        return productoRepository.save(nuevoProducto);
    }
    
    public List<Producto> findByVendedorId(Long vendedorId) {
        return productoRepository.findByVendedorId(vendedorId);
    }
}