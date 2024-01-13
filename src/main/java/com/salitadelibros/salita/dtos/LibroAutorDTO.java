package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.LibroAutor;

import java.util.Set;
import java.util.stream.Collectors;

public class LibroAutorDTO {
    private Long id;
    private Long libroId;
    private Set<AutorDTO> autores;

    //constructores
    public LibroAutorDTO(){
    }
    public LibroAutorDTO(LibroAutor libroAutor) {
        this.id = libroAutor.getId();
        this.libroId = libroAutor.getLibro().getId();
        this.autores = libroAutor.getLibro().getAutores()
                .stream()
                .map(autor -> new AutorDTO(autor))
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public Long getLibroId() {
        return libroId;
    }

    public Set<AutorDTO> getAutores() {
        return autores;
    }
}

