package com.example.gestion_bibliotheque.controller;

import com.example.gestion_bibliotheque.entity.Utilisateur;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
import com.example.gestion_bibliotheque.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
        this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAll() {
        return ResponseEntity.ok(utilisateurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> get(@PathVariable int id) {
        return ResponseEntity.ok(utilisateurService.findById(id));
    }

    @PatchMapping
    public ResponseEntity<Utilisateur> update(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(utilisateurService.createOrUpdate(utilisateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) throws ResourceNotFoundException {
        utilisateurService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<Utilisateur> signup(@RequestBody Utilisateur utilisateur) {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return ResponseEntity.ok(utilisateurService.createOrUpdate(utilisateur));
    }

}
