package com.codigojose.libreria.services;

import com.codigojose.libreria.entities.Categoria;
import com.codigojose.libreria.entities.Libro;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface LibroService {



        List <Libro> listarTodosLosLibros();


        Libro actualizarLibro(Long id, Libro libro);


        void eliminarLibro(Long id);


        Libro crearLibro (Libro libro);



}
