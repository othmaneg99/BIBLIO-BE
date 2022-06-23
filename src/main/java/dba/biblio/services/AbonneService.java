package dba.biblio.services;

import dba.biblio.entities.Abonne;
import dba.biblio.repositories.AbonneRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AbonneService  {
    private final static String USER_NOT_FOUND_MSG = "Cet utilisateur n'existe pas";



}
