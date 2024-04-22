package com.codigojose.libreria.services.serviceimpl;

import com.codigojose.libreria.entities.Categoria;
import com.codigojose.libreria.repositories.CategoriaRepository;
import com.codigojose.libreria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Long id, Categoria categoriaActualizada) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);
        if (categoriaExistente != null) {
            categoriaExistente.setNombre(categoriaActualizada.getNombre());
            return categoriaRepository.save(categoriaExistente);
        } else {
            return null;
        }
    }

    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }



}
