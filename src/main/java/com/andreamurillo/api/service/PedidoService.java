package com.andreamurillo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.Pedido;
import com.andreamurillo.api.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findByCompradorId(Long compradorId) {
        return pedidoRepository.findByCompradorId(compradorId);
    }
    
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido actualizar(Long id, Pedido nuevoPedido) {
        nuevoPedido.setId(id);
        return pedidoRepository.save(nuevoPedido);
    }
}