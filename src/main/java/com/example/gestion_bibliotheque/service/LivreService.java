package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Auteur;
import com.example.gestion_bibliotheque.entity.Categorie;
import com.example.gestion_bibliotheque.entity.Livre;
import com.example.gestion_bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    @Autowired
    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    public List<Livre> findAllByCategorie(Categorie categorie) {
        return livreRepository.findAllByCategories(List.of(categorie));
    }

    public List<Livre> findAllByAuteur(Auteur auteur) {
        return livreRepository.findAllByAuteur(auteur);
    }

    public Livre findById(int id) {
        return livreRepository.findById(id).orElse(null);
    }

    public Livre findByTitre(String titre) {
        return livreRepository.findByTitre(titre);
    }

    public Livre createOrUpdate(Livre livre) {
        return livreRepository.save(livre);
    }

    public void delete(int id) {
        livreRepository.deleteById(id);
    }

    public void delete(Livre livre) {
        livreRepository.delete(livre);
    }

}
