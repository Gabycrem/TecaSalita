package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.*;

import java.util.Set;
import java.util.stream.Collectors;

public class LibroDTO {
    private Long id;
    private String titulo;
    private Genero genero;
    private String fechaDeEdicion;
    private String isbn;
    private Set<LibroCategoriaDTO> categorias;
    private Editorial editorial;
    private Set<LibroAutorDTO> autores;
    private Set<LibroIlustradorDTO> ilustradores;


    // Constructores

    public LibroDTO(Libro libro) {
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.genero = libro.getGenero();
        this.categorias = libro.getLibroCategorias()
                .stream()
                .map(libroCategoria -> new LibroCategoriaDTO(libroCategoria))
                .collect(Collectors.toSet());
        this.editorial = libro.getEditorial();
        this.autores = libro.getLibroAutores()
                .stream()
                .map(libroAutor -> new LibroAutorDTO(libroAutor))
                .collect(Collectors.toSet());
        ilustradores = libro.getLibroIlustradores()
                .stream()
                .map(libroIlustrador -> new LibroIlustradorDTO(libroIlustrador))
                .collect(Collectors.toSet());
        fechaDeEdicion = libro.getFechaDeEdicion();
        isbn = libro.getIsbn();
    }


    // Getters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public Set<LibroCategoriaDTO> getCategorias() {
        return categorias;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Set<LibroAutorDTO> getAutores() {
        return autores;
    }

    public Set<LibroIlustradorDTO> getIlustradores() {
        return ilustradores;
    }

    public String getFechaDeEdicion() {
        return fechaDeEdicion;
    }

    public String getIsbn() {
        return isbn;
    }

}
