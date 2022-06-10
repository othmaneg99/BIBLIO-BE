package dba.biblio.controllers;

import dba.biblio.entities.Abonne;
import dba.biblio.services.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbonneController {
    @Autowired
    private AbonneService abonneService;
    @PostMapping("/register")
    public Abonne saveAbonne(@RequestBody Abonne abonne){
        return abonneService.saveAbonne(abonne);
    }

}

