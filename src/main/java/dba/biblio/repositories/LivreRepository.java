package dba.biblio.repositories;

import dba.biblio.entities.Abonne;
import dba.biblio.entities.Livre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
@CrossOrigin
public interface LivreRepository extends JpaRepository<Livre,Long>  {


     List<Livre> findByTitreContains(@Param("mc") String mc);

    @Query(nativeQuery = true,
            value = "SELECT * FROM livre l inner join auteur a on l.auteur_id = a.id WHERE LOWER(l.titre) LIKE lower('%' || ?1 || '%') or LOWER(a.prenom || ' ' || a.nom) LIKE lower('%' || ?1 || '%') or LOWER(a.nom || ' ' || a.prenom) LIKE lower('%' || ?1 || '%')")
     List<Livre> findByMultiple(@Param("mc") String mc);

     List<Livre> findAll();

     List<Livre> findAllBygenreId(@Param("genreId") Long genreId);

     List<Livre> findAllByediteurId(@Param("editeurId") Long editeurId);

     List<Livre> findAllByrayonId(@Param("rayonId") Long rayonId);


}