package com.example.gestion_bibliotheque.controller;

import com.example.gestion_bibliotheque.entity.Emprunt;
import com.example.gestion_bibliotheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    private final EmpruntService empruntService;

    @Autowired
    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
    }

    @GetMapping
    public ResponseEntity<List<Emprunt>> getAll() {
        return ResponseEntity.ok(empruntService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> get(@PathVariable int id) {
        return ResponseEntity.ok(empruntService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Emprunt> createOrUpdate(Emprunt emprunt) {
        return ResponseEntity.ok(empruntService.createOrUpdate(emprunt));
    }

}
