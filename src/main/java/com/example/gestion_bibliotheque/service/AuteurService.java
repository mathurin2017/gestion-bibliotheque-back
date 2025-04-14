package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Auteur;
import com.example.gestion_bibliotheque.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {

    private final AuteurRepository auteurRepository;

    @Autowired
    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public List<Auteur> findAll() {
        return auteurRepository.findAll();
    }

    public Auteur findById(int id) {
        return auteurRepository.findById(id).orElse(null);
    }

    public Auteur findByNom(String nom) {
        return auteurRepository.findByNom(nom);
    }

    public Auteur createOrUpdate(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    public void delete(int id) {
        auteurRepository.deleteById(id);
    }

    public void delete(Auteur auteur) {
        auteurRepository.delete(auteur);
    }

}
