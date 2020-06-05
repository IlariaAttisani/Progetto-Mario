package org.generation.italy.progettoMario.controller;

import java.util.Optional;

import org.generation.italy.progettoMario.entities.Colore;
import org.generation.italy.progettoMario.repositories.CrudColore;
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
@RequestMapping("/colori")
public class ColoreController {
	
	@Autowired
	private CrudColore database;

	@GetMapping
	public Iterable<Colore> get() {
		return database.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Colore> get(@PathVariable int id) {
		return database.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Colore colore) {
		database.save(colore);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		database.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Colore colore) {
		if (database.findById(colore.getId()).isPresent()) {
			database.save(colore);
		}
	}
}
