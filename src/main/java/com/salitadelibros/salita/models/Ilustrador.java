package com.salitadelibros.salita.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Ilustrador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String nombreIlustrador;
    private String apellidoIlustrador;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ilustrador", cascade = CascadeType.ALL)
    private Set<LibroIlustrador> libros = new HashSet<>();

    // constructores

    public Ilustrador() {
    }

    public Ilustrador(String nombreIlustrador, String apellidoIlustrador) {
        this.nombreIlustrador = nombreIlustrador;
        this.apellidoIlustrador = apellidoIlustrador;
    }

    //getters //setters
    public Long getId() { return id; }
    public String getNombreIlustrador() {
        return nombreIlustrador;
    }
    public void setNombreIlustrador(String nombreIlustrador) {
        this.nombreIlustrador = nombreIlustrador;
    }

    public String getApellidoIlustrador() {
        return apellidoIlustrador;
    }

    public void setApellidoIlustrador(String apellidoIlustrador) {
        this.apellidoIlustrador = apellidoIlustrador;
    }
    public Set<LibroIlustrador> getLibroIlustrador() {
        return libros;
    }


    //metodos

    public void addLibroIlustrador (LibroIlustrador libroIlustrador) {
        libroIlustrador.setIlustrador(this);
        libros.add(libroIlustrador);
    }

    public List<Libro> getLibros(){
        return libros.stream().map(libroIlustrador -> libroIlustrador.getLibro())
                .collect(Collectors.toList());
    }


}
