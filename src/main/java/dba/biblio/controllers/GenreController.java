package dba.biblio.controllers;

import dba.biblio.entities.Genre;
import dba.biblio.entities.Livre;
import dba.biblio.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping(path = "/genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @PostMapping("/admin/genre/create")
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }


    @DeleteMapping("/admin/genres/{id}")
    public Map<String, Boolean> deleteGenre(@PathVariable(value = "id") Long genreId)
            throws ResourceNotFoundException {
        Genre category = genreRepository.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("il n'éxsiste pas de genre pour ce id :: " + genreId));

        genreRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
