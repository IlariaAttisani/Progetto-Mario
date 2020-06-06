package org.generation.italy.progettoMario.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capi")
public class CapoController {

	@Autowired
	private CrudCapo database;
	
//	@GetMapping
//	public Iterable<Capo> get(@RequestParam(defaultValue ="") String search) {
//		if (search.equals(""))
//			return database.findAll();
//		Map<String, String> ris = new HashMap<>();
//		ris.put("colore", search);
//		ris.put("nome", search);
//		ris.put("taglia", search);
//		ris.put("categoria.nome", search);
//		return database.search(ris.get("colore"), ris.get("nome"), ris.get("taglia"), ris.get("categoria.nome"));
//	}

	@GetMapping("/{id}")
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
	
	@GetMapping("/{cmd}")
	public Iterable<Capo> OrderBy(@PathVariable String cmd, @RequestParam String search) {
		Iterable<Capo> ris = new ArrayList<>();
		if (search.equals("")) {
			
		switch (cmd) {
			case "nome":
				ris = database.orderByName();
			break;
			case "colore":
				ris = database.orderByColore();
			break;
			case "taglia":
				ris = database.orderByTaglia();
			break;
			case "prezzo":
				ris = database.orderByPrezzo();
			break;
			case "quantita":
				ris = database.orderByQuantita();
			break;
			default:
				ris = database.findAll();
		}
		} else {
			Map<String, String> rissa = new HashMap<>();
			rissa.put("colore", search);
			rissa.put("nome", search);
			rissa.put("taglia", search);
			rissa.put("categoria.nome", search);
			return database.search(rissa.get("colore"), rissa.get("nome"), rissa.get("taglia"), rissa.get("categoria.nome"));
		}
		return ris;
	}
	
	@GetMapping("/{min, max}")
	public Iterable<Capo> Filter(@RequestParam int min, int max) {
		return database.filter(min, max);
	}

	@GetMapping("/{sex}")
	public Iterable<Capo> FilterBySex(@RequestParam String sex) {
		return database.filterBySex(sex);
	}

}
