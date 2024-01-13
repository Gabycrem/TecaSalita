package com.salitadelibros.salita.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombreAutor;
    private String apellidoAutor;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "autor", cascade = CascadeType.ALL)
    private Set<LibroAutor> libros = new HashSet<>();

    // Constructores

    public Autor() {
    }
    public Autor(String nombreAutor, String apellidoAutor) {
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
    }

    // Getters // Setters

    public long getId() {
        return id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }
    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public Set<LibroAutor> getLibroAutor() {
        return libros;
    }



    // Método addLibroAutor

    public void addLibroAutor(LibroAutor libroAutor) {
        libroAutor.setAutor(this);
        libros.add(libroAutor);
    }

    public List<Libro> getLibros(){
        return libros.stream().map(libroAutor -> libroAutor.getLibro())
                .collect(Collectors.toList());
    }
}
