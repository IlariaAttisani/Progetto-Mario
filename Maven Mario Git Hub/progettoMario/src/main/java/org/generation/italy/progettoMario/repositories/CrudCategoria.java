package org.generation.italy.progettoMario.repositories;

import java.util.List;

import org.generation.italy.progettoMario.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudCategoria extends CrudRepository<Categoria, Integer> {
	
	public static final String ORDER_BY_NOME = "SELECT * FROM categoria ORDER BY nome";

	@Query(value = ORDER_BY_NOME, nativeQuery = true)
	public List<Categoria> orderByNome();
	
}
