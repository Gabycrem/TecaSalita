package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.Editorial;

import java.util.Set;
import java.util.stream.Collectors;

public class EditorialDTO {
    private Long id;

    private String nombreEditorial;

    private Set<LibroDTO> libros;



    public EditorialDTO(Editorial editorial) {
        this.id = editorial.getId();
        this.nombreEditorial = editorial.getNombreEditorial();
        this.libros = editorial.getLibros().stream().map(libro -> new LibroDTO(libro)).collect(Collectors.toSet());

    }

    public Long getId() {
        return id;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public Set<LibroDTO> getLibros() {
        return libros;
    }
}
