package com.andreamurillo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreamurillo.api.model.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {}
