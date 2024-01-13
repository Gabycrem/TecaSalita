package com.salitadelibros.salita.dtos;

import com.salitadelibros.salita.models.Ilustrador;
import com.salitadelibros.salita.models.LibroIlustrador;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IlustradorDTO {
    private Long id;
    private String nombreIlustrador;
    private String apellidoIlustrador;
    private List<LibroIlustradorDTO> libros;

    // Constructores
    public IlustradorDTO() {
    }

    public IlustradorDTO(Ilustrador ilustrador) {
        this.id = ilustrador.getId();
        this.nombreIlustrador = ilustrador.getNombreIlustrador();
        this.apellidoIlustrador = ilustrador.getApellidoIlustrador();
        this.libros = ilustrador.getLibroIlustrador()
                .stream()
                .map(libroIlustrador -> new LibroIlustradorDTO(libroIlustrador))
                .collect(Collectors.toList());
    }

    // getters

    public long getId() {
        return id;
    }

    public String getNombreIlustrador() {
        return nombreIlustrador;
    }

    public String getApellidoIlustrador() {
        return apellidoIlustrador;
    }

    public List<LibroIlustradorDTO> getLibros() {
        return libros;
    }
}
