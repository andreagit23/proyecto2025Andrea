package com.andreamurillo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreamurillo.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByCompradorId(Long compradorId);
}
