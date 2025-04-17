package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Auteur;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
import com.example.gestion_bibliotheque.repository.AuteurRepository;
import com.example.gestion_bibliotheque.utils.FunctionUtils;
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
        FunctionUtils.validateId(id);
        return auteurRepository.findById(id).orElse(null);
    }

    public Auteur createOrUpdate(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    public void delete(int id) throws ResourceNotFoundException {
        if (!auteurRepository.existsById(id)) throw new ResourceNotFoundException("Auteur with id " + id + " not found.");
        auteurRepository.deleteById(id);
    }

}
