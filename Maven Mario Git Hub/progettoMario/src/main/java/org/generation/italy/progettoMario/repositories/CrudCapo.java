package org.generation.italy.progettoMario.repositories;

import java.util.List;

import org.generation.italy.progettoMario.entities.Capo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudCapo extends CrudRepository<Capo, Integer> {
	
	public static final String FILTER_BY_SEX = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id WHERE sesso = ?";
	public static final String FILTER_BY_RANGE_PREZZO = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id WHERE prezzo >= ? AND prezzo <= ? ORDER BY prezzo";
	public static final String SEARCH_BY_STRING = "SELECT * FROM capo INNER JOIN categoria on id_categoria = categoria.id "
			+ "WHERE capo.colore LIKE %?% OR capo.nome LIKE %?% OR capo.taglia LIKE %?% OR categoria.nome LIKE %?%;";
	public static final String ORDER_BY_TAGLIA = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id ORDER BY FIELD(taglia, 'xxs', 'xs', 's', 'm', 'l', 'xl', 'xxl')";
	public static final String ORDER_BY_QUANTITA = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id ORDER BY capo.quantita";
	public static final String ORDER_BY_PREZZO = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id ORDER BY capo.prezzo";
	public static final String ORDER_BY_COLORE = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id ORDER BY capo.colore";
	public static final String ORDER_BY_NOME = "SELECT * FROM capo inner join categoria on id_categoria = categoria.id ORDER BY capo.nome";

	@Query(value = ORDER_BY_NOME, nativeQuery = true)
	public List<Capo> orderByName();

	@Query(value = ORDER_BY_COLORE, nativeQuery = true)
	public List<Capo> orderByColore();
	
	@Query(value = ORDER_BY_PREZZO, nativeQuery = true)
	public List<Capo> orderByPrezzo();
	
	@Query(value = ORDER_BY_TAGLIA, nativeQuery = true)
	public List<Capo> orderByTaglia();
	
	@Query(value = ORDER_BY_QUANTITA, nativeQuery = true)
	public List<Capo> orderByQuantita();
	
	@Query(value = SEARCH_BY_STRING, nativeQuery = true)
	public List<Capo> search(String colore, String nome, String taglia, String categoria);
	
	@Query(value = FILTER_BY_RANGE_PREZZO, nativeQuery = true)
	public List<Capo> findByPrezzo(@Param(value = "min") int min, @Param(value = "max") int max);

	@Query(value = FILTER_BY_SEX, nativeQuery = true)
	public List<Capo> findBySex(String sex);
	
}
