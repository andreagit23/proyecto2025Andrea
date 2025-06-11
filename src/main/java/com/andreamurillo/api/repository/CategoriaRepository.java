package com.andreamurillo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreamurillo.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
