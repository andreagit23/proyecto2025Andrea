package com.andreamurillo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.Transaccion;
import com.andreamurillo.api.repository.TransaccionRepository;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    public List<Transaccion> listarPorUsuario(Long usuarioId) {
        return transaccionRepository.findByUsuarioId(usuarioId);
    }

    public Transaccion guardar(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public void eliminar(Long id) {
        transaccionRepository.deleteById(id);
    }

    public Transaccion actualizar(Long id, Transaccion nuevaTransaccion) {
        nuevaTransaccion.setId(id);
        return transaccionRepository.save(nuevaTransaccion);
    }
}
