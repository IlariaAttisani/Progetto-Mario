package org.generation.italy.progettoMario.repositories;

import java.util.List;

import org.generation.italy.progettoMario.entities.Capo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudCapo extends CrudRepository<Capo, Integer> {

	Iterable<Capo> findAll(Specification<Capo> specification);

	List<Capo> findByNome(String nome);
	List<Capo> findByCategoria(String categoria);
	List<Capo> findByColore(String colore);
	List<Capo> findByTaglia(String taglia);

//	List<Capo> findByNomeContaining(String testo);
	
}
