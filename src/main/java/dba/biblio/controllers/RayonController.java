package dba.biblio.controllers;

import dba.biblio.entities.Genre;
import dba.biblio.entities.Rayon;
import dba.biblio.repositories.GenreRepository;
import dba.biblio.repositories.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class RayonController {

    @Autowired
    private RayonRepository rayonRepository;

    @GetMapping(path = "/rayons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rayon> getRayons() {
        return rayonRepository.findAll();
    }

    @PostMapping("/admin/rayon/create")
    public Rayon createRayon(@RequestBody Rayon rayon) {
        return rayonRepository.save(rayon);
    }


    @DeleteMapping("/admin/rayons/{id}")
    public Map<String, Boolean> deleteGenre(@PathVariable(value = "id") Long rayonId)
            throws ResourceNotFoundException {
        Rayon category = rayonRepository.findById(rayonId)
                .orElseThrow(() -> new ResourceNotFoundException("il n'éxsiste pas de rayon pour ce id :: " + rayonId));

        rayonRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
