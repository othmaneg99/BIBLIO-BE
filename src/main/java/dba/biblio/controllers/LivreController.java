package dba.biblio.controllers;

import dba.biblio.entities.Livre;
import dba.biblio.repositories.LivreRepository;
import dba.biblio.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/livre")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private LivreRepository livreRepository;


    @GetMapping("/list")
    public ResponseEntity<Page<Livre>> get(@RequestParam(required = false) String criteria, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(livreService.getAll(criteria, pageRequest));
    }

    @PostMapping
    public void save(Livre livre) {
        livreService.save(livre);
    }

    @PutMapping
    public void update(Livre livre) throws Exception {
        livreService.update(livre);
    }
    @GetMapping("/search")
    public List<Livre> findByTitre(@RequestParam String mc){
        return this.livreRepository.findByTitreContains(mc);
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
}
