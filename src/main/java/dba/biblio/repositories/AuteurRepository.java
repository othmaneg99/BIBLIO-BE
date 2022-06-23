package dba.biblio.repositories;

import dba.biblio.entities.Auteur;
import dba.biblio.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin
public interface AuteurRepository extends JpaRepository<Auteur,Long> {


}
