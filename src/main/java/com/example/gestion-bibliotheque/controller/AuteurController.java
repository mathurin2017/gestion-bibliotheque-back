package com.example.gestion_bibliotheque.controller;

import com.example.gestion_bibliotheque.entity.Auteur;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
import com.example.gestion_bibliotheque.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {

    private final AuteurService auteurService;

    @Autowired
    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @GetMapping
    public ResponseEntity<List<Auteur>> getAll() {
        return ResponseEntity.ok(auteurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auteur> get(@PathVariable Integer id) {
        return ResponseEntity.ok(auteurService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Auteur> createOrUpdate(@RequestBody Auteur auteur) {
        return ResponseEntity.ok(auteurService.createOrUpdate(auteur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        auteurService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
