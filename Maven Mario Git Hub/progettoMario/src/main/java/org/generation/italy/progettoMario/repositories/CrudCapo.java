package org.generation.italy.progettoMario.repositories;

import java.util.List;
import java.util.Optional;

import org.generation.italy.progettoMario.entities.Capo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface CrudCapo extends CrudRepository<Capo, Integer> {
	
	public static final String FILTER_BY_SEX = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" +
			" FROM capo inner join categoria on id_categoria = categoria.id WHERE sesso = ?";
	public static final String FILTER_BY_RANGE_PREZZO = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" + 
			" FROM capo inner join categoria on id_categoria = categoria.id WHERE prezzo >= ? AND prezzo <= ? ORDER BY prezzo";
	public static final String SEARCH_BY_STRING = "SELECT * FROM capo INNER JOIN categoria on id_categoria = categoria.id "
			+ "WHERE capo.colore LIKE %?% OR capo.nome LIKE %?% OR capo.taglia LIKE %?% OR categoria.nome LIKE %?%;";
	public static final String ORDER_BY_TAGLIA = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" + 
			" FROM capo inner join categoria on id_categoria = categoria.id ORDER BY FIELD(taglia, 'xxs', 'xs', 's', 'm', 'l', 'xl', 'xxl')";
	public static final String ORDER_BY_QUANTITA = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" + 
			" FROM capo inner join categoria on id_categoria = categoria.id ORDER BY quantita.nome";
	public static final String ORDER_BY_PREZZO = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" + 
			" FROM capo inner join categoria on id_categoria = categoria.id ORDER BY prezzo.nome";
	public static final String ORDER_BY_COLORE = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" + 
			" FROM capo inner join categoria on id_categoria = categoria.id ORDER BY colore.nome";
	public static final String ORDER_BY_NOME = "SELECT capo.id, capo.codice_articolo, capo.colore, capo.nome, capo.prezzo, capo.quantita, capo.taglia, capo.sesso, categoria.nome" + 
			" FROM capo inner join categoria on id_categoria = categoria.id ORDER BY capo.nome";

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
	public List<Capo> filter(int min, int max);

	@Query(value = FILTER_BY_SEX, nativeQuery = true)
	public List<Capo> filterBySex(String sex);
	
}
