package org.generation.italy.progettoMario.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.sql.rowset.Predicate;

import org.generation.italy.progettoMario.entities.Capo;
import org.generation.italy.progettoMario.repositories.CrudCapo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
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

	@GetMapping
	public Iterable<Capo> ricerca(String testo) {
		List<Capo> ris = new ArrayList<>();
		if (!testo.equals("")) {
		// addAll() aggiunge una lista di capo e non un capo come con add()
		ris.addAll(database.findByNome(testo));
		ris.addAll(database.findByCategoria(testo));
		ris.addAll(database.findByColore(testo));
		ris.addAll(database.findByTaglia(testo));
//		ris.addAll(database.findByNomeContaining(testo));
		}
		return ris;
	}
	
//	@GetMapping
//	public Iterable<Capo> findByLikeCriteria(String testo) {
//		return database.findAll(new Specification<Capo>() {
//			public javax.persistence.criteria.Predicate toPredicate(Root<Capo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				List<Predicate> predicates = new ArrayList<>();
//				if (testo != null) {
//					predicates.add((Predicate) criteriaBuilder.or(
//							criteriaBuilder.like(root.get("nome"), "%" + testo + "%"),
//							criteriaBuilder.like(root.get("categoria"), "%" + testo + "%"),
//							criteriaBuilder.like(root.get("colore"), "%" + testo + "%"),
//							criteriaBuilder.like(root.get("taglia"), "%" + testo + "%"))
//							);
//				}
//				return criteriaBuilder.and((javax.persistence.criteria.Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
//			}
//		});
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
}
