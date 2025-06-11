package com.andreamurillo.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.Comprobante;
import com.andreamurillo.api.repository.ComprobanteRepository;

@Service
public class ComprobanteService {
    @Autowired
    private ComprobanteRepository comprobanteRepository;

    public Optional<Comprobante> buscarPorProductoId(Long productoId) {
        return comprobanteRepository.findByProductoId(productoId);
    }

    public Comprobante guardar(Comprobante comprobante) {
        return comprobanteRepository.save(comprobante);
    }

    public void eliminar(Long id) {
        comprobanteRepository.deleteById(id);
    }

    public Comprobante actualizar(Long id, Comprobante nuevoComprobante) {
        nuevoComprobante.setId(id);
        return comprobanteRepository.save(nuevoComprobante);
    }
}
