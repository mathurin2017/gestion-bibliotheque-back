package com.example.gestion_bibliotheque.controller;

import com.example.gestion_bibliotheque.entity.Livre;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
import com.example.gestion_bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public ResponseEntity<List<Livre>> getAll() {
        return ResponseEntity.ok(livreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> get(@PathVariable int id) {
        return ResponseEntity.ok(livreService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Livre> createOrUpdate(@RequestBody Livre livre) {
        return ResponseEntity.ok(livreService.createOrUpdate(livre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws ResourceNotFoundException {
        livreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
