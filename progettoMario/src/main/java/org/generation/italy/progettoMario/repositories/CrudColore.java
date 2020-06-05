package org.generation.italy.progettoMario.repositories;

import org.generation.italy.progettoMario.entities.Colore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudColore extends CrudRepository<Colore, Integer>{

}
