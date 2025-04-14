package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Auteur;
import com.example.gestion_bibliotheque.entity.Categorie;
import com.example.gestion_bibliotheque.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public Categorie findById(int id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie findByNom(String nom) {
        return categorieRepository.findByNom(nom);
    }

    public Categorie createOrUpdate(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void delete(int id) {
        categorieRepository.deleteById(id);
    }

    public void delete(Categorie categorie) {
        categorieRepository.delete(categorie);
    }

}
