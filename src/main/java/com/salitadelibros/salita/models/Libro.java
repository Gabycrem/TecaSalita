package com.salitadelibros.salita.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.MultiValueMap;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Libro {

    //------------------- Propiedades ---------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @Column(name = "Titulo", nullable = false)
    private String titulo;
    @Column(name = "fecha_de_edicion")
    private String fechaDeEdicion;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String isbn;


    // -------------------Relaciones----------------//
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "editorial_id")
    private Editorial editorial; //chek

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "libro", cascade = CascadeType.ALL)
    private Set<LibroCategoria> categorias = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "libro", cascade = CascadeType.ALL)
    private Set<LibroIlustrador> ilustradores = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "libro", cascade = CascadeType.ALL)
    private Set<LibroAutor> autores = new HashSet<>();

    // ---------------------Constructores -------------------//

    public Libro() {
    }

    public Libro(String titulo, String fechaDeEdicion, Genero genero, String isbn) {
        this.titulo = titulo;
        this.fechaDeEdicion = fechaDeEdicion;
        this.genero = genero;
        this.isbn= isbn;
    }

    public Libro(MultiValueMap<String, String> libroData) {
        if (libroData != null) {
            // Extraer y asignar los datos del MultiValueMap a las propiedades del libro
            this.titulo = libroData.getFirst("titulo");
            this.fechaDeEdicion = libroData.getFirst("fechaDeEdicion");
            this.genero = Genero.valueOf(libroData.getFirst("genero"));
            this.isbn = libroData.getFirst("isbn");
        }
    }

    //----------------- Getters y Setters------------------//
    // getters
    // id tiene solo get
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getFechaDeEdicion() {
        return fechaDeEdicion;
    }
    public Genero getGenero() {
        return genero;
    }
    public String getIsbn() {
        return isbn;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Set<LibroCategoria> getCategorias() {
        return categorias;
    }

    public Set<LibroIlustrador> getIlustradores() {
        return ilustradores;
    }

    public Set<LibroAutor> getAutores() {
        return autores;
    }


    //y setters

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setFechaDeEdicion(String fechaDeEdicion) {
        this.fechaDeEdicion = fechaDeEdicion;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    // ---------- Métodos ADD y Otros ----------------- //

    public void addLibroAutor(LibroAutor libroAutor) {
        libroAutor.setLibro(this);
        autores.add(libroAutor);
    }

    public void addLibroIlustrador(LibroIlustrador libroIlustrador){
        libroIlustrador.setLibro(this);
        ilustradores.add(libroIlustrador);
    }
    public void addLibroCategoria(LibroCategoria libroCategoria){
        libroCategoria.setLibro(this);
        categorias.add(libroCategoria);
    }

    /*public void addEditorial(Editorial editorial){
        this.editorial = editorial;
        editorial.getLibros().add(this);
    }*/
}
