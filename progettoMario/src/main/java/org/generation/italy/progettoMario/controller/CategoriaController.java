package org.generation.italy.progettoMario.controller;

import java.util.Optional;

import org.generation.italy.progettoMario.entities.Categoria;
import org.generation.italy.progettoMario.repositories.CrudCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

	@Autowired
	private CrudCategoria database;
	
	@GetMapping
	public Iterable<Categoria> get() {
		return database.findAll();
	}
	
	@GetMapping("{/id}")
	public Optional<Categoria> get(@PathVariable int id) {
		return database.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Categoria categoria) {
		database.save(categoria);
	}
	
	@DeleteMapping("{/id}")
	public void delete(@PathVariable int id) {
		database.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Categoria categoria) {
		if (database.findById(categoria.getId()).isPresent()) {
			database.save(categoria);
		}
	}
}
