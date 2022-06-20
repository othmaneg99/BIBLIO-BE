package dba.biblio.controllers;

import dba.biblio.entities.Abonne;
import dba.biblio.repositories.AbonneRepository;
import dba.biblio.services.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin
@RestController
public class AbonneController {
    @Autowired
    private AbonneService abonneService;

    @PostMapping("/register")
    public Abonne saveAbonne(@RequestBody Abonne abonne){

        return abonneService.saveAbonne(abonne);
    }
    @Autowired

    private AbonneRepository abonneRepository;
    @PostMapping("/login")
    public ResponseEntity<Abonne> login(@RequestBody  Abonne userData) {

        Abonne abonne = abonneRepository.findByUsername(userData.getUsername());



            if( abonne.getPassword().equals(userData.getPassword()))
                return ResponseEntity.ok(abonne);

            return (ResponseEntity<Abonne>) ResponseEntity.internalServerError();
    }





}

