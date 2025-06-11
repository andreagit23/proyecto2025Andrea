package com.andreamurillo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.Ong;
import com.andreamurillo.api.repository.OngRepository;

@Service
public class OngService {
    @Autowired
    private OngRepository ongRepository;

    public List<Ong> listarOngs() {
        return ongRepository.findAll();
    }

    public Ong guardar(Ong ong) {
        return ongRepository.save(ong);
    }

    public void eliminar(Long id) {
        ongRepository.deleteById(id);
    }

    public Ong actualizar(Long id, Ong nuevaOng) {
        nuevaOng.setId(id);
        return ongRepository.save(nuevaOng);
    }
}