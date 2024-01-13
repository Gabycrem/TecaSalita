package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.LibroCategoria;

import java.util.Set;
import java.util.stream.Collectors;

public class LibroCategoriaDTO {
    private Long id;
    private Long libroId;
    private Set<CategoriaDTO> categorias;

    //Constructores
    public LibroCategoriaDTO() {
    }
    public LibroCategoriaDTO(LibroCategoria libroCategoria) {
        this.id = libroCategoria.getId();
        this.libroId = libroCategoria.getLibro().getId();
        this.categorias = libroCategoria.getLibro().getCategorias()
                .stream()
                .map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toSet());
    }

    //getters
    public Long getId() {
        return id;
    }
    public Long getLibroId() {
        return libroId;
    }

    public Set<CategoriaDTO> getCategorias() {
        return categorias;
    }
}
