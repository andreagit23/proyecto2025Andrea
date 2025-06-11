package com.andreamurillo.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.Monedero;
import com.andreamurillo.api.repository.MonederoRepository;

@Service
public class MonederoService {
    @Autowired
    private MonederoRepository monederoRepository;

    public Optional<Monedero> buscarPorUsuarioId(Long usuarioId) {
        return monederoRepository.findByUsuarioId(usuarioId);
    }

    public Monedero guardar(Monedero monedero) {
        return monederoRepository.save(monedero);
    }
    
    public void eliminar(Long id) {
    	monederoRepository.deleteById(id);
    }
}
