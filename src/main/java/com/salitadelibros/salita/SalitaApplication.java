package com.salitadelibros.salita;

import com.salitadelibros.salita.models.*;
import com.salitadelibros.salita.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SalitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalitaApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(LibroRepositorio libroRepositorio,
									  AutorRepositorio autorRepositorio,
									  IlustradorRepositorio ilustradorRepositorio,
									  EditorialRepositorio editorialRepositorio,
									  LibroAutorRepositorio libroAutorRepositorio,
									  CategoriaRepositorio categoriaRepositorio,
									  UsuarioRepositorio usuarioRepositorio){

		return (args -> {

			Editorial editorial1= new Editorial("AZ editores");
			editorialRepositorio.save(editorial1);
			Autor autor1 = new Autor("Dimas", "Cabrera");
			autorRepositorio.save(autor1);
			Ilustrador ilustrador1 = new Ilustrador("Agustina", "Di Mauro");
			ilustradorRepositorio.save(ilustrador1);
			Categoria categoria1 = new Categoria("Pizza");
			categoriaRepositorio.save(categoria1);
			Editorial editorial2= new Editorial("Editorial Planeta");
			editorialRepositorio.save(editorial2);
			Autor autor2 = new Autor("J.R.R.", "Tolkien");
			autorRepositorio.save(autor2);
			Ilustrador ilustrador2 = new Ilustrador("Ted", "Nasmith");
			ilustradorRepositorio.save(ilustrador2);
			Categoria categoria2 = new Categoria("Mitos y Leyendas");
			categoriaRepositorio.save(categoria2);
	});
}

}