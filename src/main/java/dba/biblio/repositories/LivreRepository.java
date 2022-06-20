package dba.biblio.repositories;

import dba.biblio.entities.Abonne;
import dba.biblio.entities.Livre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

public interface LivreRepository extends JpaRepository<Livre,Long> , JpaSpecificationExecutor<Livre> {


    public List<Livre> findByTitreContains(@Param("mc") String mc);

    public List<Livre> findAll();
}
