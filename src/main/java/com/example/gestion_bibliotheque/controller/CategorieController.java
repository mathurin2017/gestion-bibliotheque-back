package com.example.gestion_bibliotheque.controller;

import com.example.gestion_bibliotheque.entity.Categorie;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
import com.example.gestion_bibliotheque.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAll() {
        return ResponseEntity.ok(categorieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> get(@PathVariable int id) {
        return ResponseEntity.ok(categorieService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Categorie> createOrUpdate(@RequestBody Categorie categorie) {
        return ResponseEntity.ok(categorieService.createOrUpdate(categorie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws ResourceNotFoundException {
        categorieService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
