package org.generation.italy.progettoMario.repositories;

import org.generation.italy.progettoMario.entities.Capo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudCapo extends CrudRepository<Capo, Integer> {

}
