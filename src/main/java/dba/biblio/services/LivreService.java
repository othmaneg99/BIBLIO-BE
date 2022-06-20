package dba.biblio.services;

import dba.biblio.entities.Livre;
import dba.biblio.repositories.LivreRepository;
import dba.biblio.repositories.specification.LivreSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public Page<Livre> getAll(String criteria, Pageable pageable) {
        return livreRepository.findAll(Specification.where(LivreSpecification.findBy("titre", criteria))
                .or(LivreSpecification.findBy("genre", criteria)), pageable);

    }

    public Optional<Livre> findById(Long id) {
        return livreRepository.findById(id);
    }

    public void save(Livre livre) {
        livreRepository.save(livre);
    }

    public void update(Livre livre) throws Exception {
        if (!findById(livre.getId()).isPresent())
            throw new Exception("Livre not found");
        livreRepository.save(livre);
    }
}
