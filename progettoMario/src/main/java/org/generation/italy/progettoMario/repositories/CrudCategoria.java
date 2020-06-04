package org.generation.italy.progettoMario.repositories;

import org.generation.italy.progettoMario.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudCategoria extends CrudRepository<Categoria, Integer> {

}
