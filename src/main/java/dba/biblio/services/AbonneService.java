package dba.biblio.services;

import dba.biblio.entities.Abonne;
import dba.biblio.repositories.AbonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonneService {
    @Autowired
    private AbonneRepository abonneRepository;
    public  Abonne saveAbonne(Abonne abonne){
        return abonneRepository.save(abonne);
    }
}
