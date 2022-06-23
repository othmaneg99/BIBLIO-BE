package dba.biblio.controllers;

import dba.biblio.entities.Editeur;
import dba.biblio.entities.Genre;
import dba.biblio.repositories.EditeurRepository;
import dba.biblio.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class EditeurController {

    @Autowired
    private EditeurRepository editeurRepository;

    @GetMapping(path = "/editeurs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Editeur> getEditeurs() {
        return editeurRepository.findAll();
    }

    @PostMapping("/admin/editeur/create")
    public Editeur createEditeur(@RequestBody Editeur editeur) {
        return editeurRepository.save(editeur);
    }


    @DeleteMapping("/admin/editeurs/{id}")
    public Map<String, Boolean> deleteEditeur(@PathVariable(value = "id") Long editeurId)
            throws ResourceNotFoundException {
        Editeur editeur = editeurRepository.findById(editeurId)
                .orElseThrow(() -> new ResourceNotFoundException("il n'éxsiste pas de genre pour ce id :: " + editeurId));

        editeurRepository.delete(editeur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
