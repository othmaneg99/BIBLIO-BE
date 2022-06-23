package dba.biblio.controllers;

import dba.biblio.entities.Genre;
import dba.biblio.entities.Livre;
import dba.biblio.repositories.AuteurRepository;
import dba.biblio.repositories.LivreRepository;
import dba.biblio.services.LivreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/livre")
public class LivreController {


    @Autowired
    private  LivreRepository livreRepository;



    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Livre> getLivres() {
        return livreRepository.findAll();
    }

    @PostMapping
    public void save(Livre livre) {

    }

    @PutMapping
    public void update(Livre livre) throws Exception {

    }
    @GetMapping("/search")
    public List<Livre> findByTitre(@RequestParam String mc){
        return this.livreRepository.findByMultiple(mc);
    }


    @GetMapping(path = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        Livre l = livreRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/mundiatheque/livres/" + l.getPhotoName()));
    }
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Livre> getArticles() {
        return livreRepository.findAll();
    }

    @GetMapping("/searchbygenre")
    public List<Livre> findByGenre(@RequestParam Long genreId){
        return this.livreRepository.findAllBygenreId(genreId);
    }

    @GetMapping("/searchbyediteur")
    public List<Livre> findByEditeur(@RequestParam Long editeurId){
        return this.livreRepository.findAllByediteurId(editeurId);
    }

    @GetMapping("/searchbyrayon")
    public List<Livre> findByRayon(@RequestParam Long rayonId){
        return this.livreRepository.findAllByrayonId(rayonId);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteLivre(@PathVariable(value = "id") Long livreId)
            throws ResourceNotFoundException {
        Livre livre = livreRepository.findById(livreId)
                .orElseThrow(() -> new ResourceNotFoundException("il n'éxsiste pas de livre pour ce id :: " + livreId));

        livreRepository.delete(livre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

