package dba.biblio.repositories;

import dba.biblio.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin
public interface GenreRepository extends JpaRepository<Genre,Long> {

    @Override
    List<Genre> findAll();

    Genre save(Genre genre);
}
