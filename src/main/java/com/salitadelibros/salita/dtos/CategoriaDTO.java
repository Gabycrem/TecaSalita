package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.Categoria;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoriaDTO {
    private Long id;
    private String palabraCategoria;
    private List<LibroCategoriaDTO> libros;

    //constructores


    public CategoriaDTO(Categoria categoria){
        this.id =  categoria.getId();
        this.palabraCategoria = categoria.getPalabraCategoria();
        this.libros = categoria.getLibroCategoria()
                .stream()
                .map(libroCategoria -> new LibroCategoriaDTO(libroCategoria))
                .collect(Collectors.toList());
    }
    //getters
    public Long getId() {
        return id;
    }

    public String getPalabraCategoria() {
        return palabraCategoria;
    }

    public List<LibroCategoriaDTO> getLibros() {
        return libros;
    }
}
