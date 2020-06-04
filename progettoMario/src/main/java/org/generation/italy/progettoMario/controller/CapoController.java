package org.generation.italy.progettoMario.controller;

import java.util.Optional;

import org.generation.italy.progettoMario.entities.Capo;
import org.generation.italy.progettoMario.repositories.CrudCapo;
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
@RequestMapping("/capi")
public class CapoController {

	@Autowired
	private CrudCapo database;
	
	@GetMapping
	public Iterable<Capo> get() {
		return database.findAll();
	}
	
	@GetMapping("{/id}")
	public Optional<Capo> get(@PathVariable int id) {
		return database.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Capo capo) {
		database.save(capo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		database.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Capo capo) {
		if (database.findById(capo.getId()).isPresent()) {
			database.save(capo);
		}
	}
}
