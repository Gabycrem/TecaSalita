package com.salitadelibros.salita.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String palabraCategoria;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria",cascade = CascadeType.ALL)
    private Set<LibroCategoria> libros = new HashSet<>();

    public Categoria() {
    }
    public Categoria(String palabraCategoria){
        this.palabraCategoria = palabraCategoria;
    }
    //getters

    public Long getId() {
        return id;
    }

    public String getPalabraCategoria() {
        return palabraCategoria;
    }

    public void setPalabraCategoria(String palabraCategoria) {
        this.palabraCategoria = palabraCategoria;
    }

    public Set<LibroCategoria> getLibroCategoria() {
        return libros;
    }


    //metodo add
    public void addLibroCategoria(LibroCategoria libroCategoria){
        libroCategoria.setCategoria(this);
        libros.add(libroCategoria);
    }

    public List<Libro> getLibros(){
        return libros.stream().map(libroCategoria -> libroCategoria.getLibro())
                .collect(Collectors.toList());
    }

}
