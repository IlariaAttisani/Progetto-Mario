package org.generation.italy.progettoMario.repositories;

import org.generation.italy.progettoMario.entities.Taglia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudTaglia extends CrudRepository<Taglia, Integer> {

}
