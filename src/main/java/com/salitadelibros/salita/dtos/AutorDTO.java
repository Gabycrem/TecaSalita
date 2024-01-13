package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.Autor;
import com.salitadelibros.salita.models.LibroAutor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AutorDTO {
    private Long id;
    private String nombreAutor;
    private String apellidoAutor;
    private List<LibroAutorDTO> libros;

    public AutorDTO() {

    }

    // Método constructor que acepta una instancia de AutorDTO
    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nombreAutor = autor.getNombreAutor();
        this.apellidoAutor = autor.getApellidoAutor();
        this.libros = autor.getLibroAutor()
                .stream()
                .map(libroAutor -> new LibroAutorDTO(libroAutor))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public List<LibroAutorDTO> getLibros() {
        return libros;
    }
}
