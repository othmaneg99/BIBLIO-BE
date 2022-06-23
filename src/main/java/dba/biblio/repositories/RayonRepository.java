package dba.biblio.repositories;

import dba.biblio.entities.Genre;
import dba.biblio.entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin
public interface RayonRepository extends JpaRepository<Rayon,Long> {
    @Override
    List<Rayon> findAll();

    Rayon save(Rayon rayon);
}
