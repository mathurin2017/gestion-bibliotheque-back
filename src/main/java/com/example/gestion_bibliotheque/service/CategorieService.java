package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Categorie;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
import com.example.gestion_bibliotheque.repository.CategorieRepository;
import com.example.gestion_bibliotheque.utils.FunctionUtils;
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
        FunctionUtils.validateId(id);
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie createOrUpdate(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void delete(int id) throws ResourceNotFoundException {
        if (!categorieRepository.existsById(id)) throw new ResourceNotFoundException("Category with id " + id + " not found.");
        categorieRepository.deleteById(id);
    }

}
