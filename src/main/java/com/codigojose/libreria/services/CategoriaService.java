package com.codigojose.libreria.services;

import com.codigojose.libreria.entities.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> obtenerTodasLasCategorias();

    Categoria crearCategoria(Categoria categoria);

    Categoria actualizarCategoria(Long id, Categoria categoria);

    void eliminarCategoria(Long id);


}
