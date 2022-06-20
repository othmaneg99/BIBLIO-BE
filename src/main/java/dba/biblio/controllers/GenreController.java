package dba.biblio.controllers;

import dba.biblio.entities.Genre;
import dba.biblio.entities.Livre;
import dba.biblio.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping(path = "/genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
