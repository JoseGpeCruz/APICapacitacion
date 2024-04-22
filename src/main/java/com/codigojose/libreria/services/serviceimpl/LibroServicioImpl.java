package com.codigojose.libreria.services.serviceimpl;

import com.codigojose.libreria.entities.Libro;
import com.codigojose.libreria.repositories.LibroRepository;
import com.codigojose.libreria.services.LibroService;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class LibroServicioImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;


    public List<Libro> listarTodosLosLibros() {
        return libroRepository.findAll();
    }
//ver
    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        Libro libroExistente = libroRepository.findById(id).orElse(null);
        if (libroExistente != null) {
            // Actualiza los campos del libro existente con los del libro actualizado
            libroExistente.setTitulo(libroExistente.getTitulo());
            libroExistente.setIdioma(libroExistente.getIdioma());
            libroExistente.setCategoria(libroExistente.getCategoria());
            return libroRepository.save(libroExistente);
        } else {
            return null; // Manejar caso cuando no se encuentra el libro
        }
    }

    @Override
    public void eliminarLibro(Long id) {

    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }




}
