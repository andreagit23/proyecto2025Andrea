package com.andreamurillo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreamurillo.api.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByUsuarioId(Long usuarioId);
}

