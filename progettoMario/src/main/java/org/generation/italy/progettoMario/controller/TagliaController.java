package org.generation.italy.progettoMario.controller;

import java.util.Optional;

import org.generation.italy.progettoMario.entities.Taglia;
import org.generation.italy.progettoMario.repositories.CrudTaglia;
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
@RequestMapping("/taglie")
public class TagliaController {

	@Autowired
	private CrudTaglia database;
	
	@GetMapping
	public Iterable<Taglia> get() {
		return database.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Taglia> get(@PathVariable int id) {
		return database.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Taglia taglia) {
		database.save(taglia);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		database.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Taglia taglia) {
		if (database.findById(taglia.getId()).isPresent()) {
			database.save(taglia);
		}
	}
}
