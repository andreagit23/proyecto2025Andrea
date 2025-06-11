package com.andreamurillo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreamurillo.api.model.Categoria;
import com.andreamurillo.api.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /** Devuelve todas las categorías */
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    /** Guarda o actualiza una categoría */
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    /** Elimina una categoría por su id */
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    /** Actualiza la categoría con el id dado */
    public Categoria actualizar(Long id, Categoria nuevaCategoria) {
        nuevaCategoria.setId(id);
        return categoriaRepository.save(nuevaCategoria);
    }

    /** Busca una categoría por su id */
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }
}
