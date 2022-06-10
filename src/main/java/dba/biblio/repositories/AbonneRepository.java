package dba.biblio.repositories;

import dba.biblio.entities.Abonne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneRepository extends CrudRepository<Abonne,Long> {

}
