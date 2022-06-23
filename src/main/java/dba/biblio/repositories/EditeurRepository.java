package dba.biblio.repositories;

import dba.biblio.entities.Editeur;
import dba.biblio.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Repository
@CrossOrigin
public interface EditeurRepository extends JpaRepository<Editeur,Long> {

    @Override
    List<Editeur> findAll();

    Editeur save(Editeur editeur);


    }

