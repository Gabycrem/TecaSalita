package com.salitadelibros.salita.services.implement;

import com.salitadelibros.salita.dtos.LibroDTO;
import com.salitadelibros.salita.models.Libro;
import com.salitadelibros.salita.repositories.LibroRepositorio;
import com.salitadelibros.salita.services.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class LibroServicioImpl implements LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<LibroDTO> getLibrosDTO() {
        return libroRepositorio.findAll()
                .stream()
                .map(libro -> new LibroDTO(libro)).collect(toList());
    }

    @Override
    public Optional<Libro> getLibro(Long libroId) {
        return libroRepositorio.findById(libroId);
    }

    @Override
    public void saveOrUpdate(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void delete(Long libroId) {
        libroRepositorio.deleteById(libroId);
    }
    @Override
    public Libro getLibroById(Long id) {
        Optional<Libro> optionalLibro = libroRepositorio.findById(id);
        if (optionalLibro.isPresent()) {
            Libro libro = optionalLibro.get();
            return libro;
        }
        return null;
    }
}
