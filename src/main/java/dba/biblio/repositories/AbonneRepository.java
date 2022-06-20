package dba.biblio.repositories;

import dba.biblio.entities.Abonne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
@CrossOrigin
public interface AbonneRepository extends CrudRepository<Abonne,Long> {



    Abonne findByEmail(String email);

    Abonne findByUsername(String username);
}
