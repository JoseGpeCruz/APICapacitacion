package com.codigojose.libreria.controllers;

import com.codigojose.libreria.entities.Libro;
import com.codigojose.libreria.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/obtenerLibrosConCategorias")
    public ResponseEntity<List<Libro>> obtenerLibrosConCategorias() {
        List<Libro> libros = libroService.listarTodosLosLibros();
        return ResponseEntity.ok().body(libros);
    }

    @GetMapping("/obtenerLibros")
    public List<Libro> obtenerTodos() {
        return libroService.listarTodosLosLibros();
    }

    @PostMapping("/crearLibro")
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.crearLibro(libro);
        return ResponseEntity.ok().body(nuevoLibro);
    }

    @PutMapping("actualizar/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.actualizarLibro(id, libro);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }

}
