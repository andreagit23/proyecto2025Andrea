package com.andreamurillo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreamurillo.api.model.Monedero;

public interface MonederoRepository extends JpaRepository<Monedero, Long> {
    Optional<Monedero> findByUsuarioId(Long usuarioId);
}
