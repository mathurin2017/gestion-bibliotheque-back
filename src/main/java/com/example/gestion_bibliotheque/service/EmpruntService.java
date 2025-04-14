package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Emprunt;
import com.example.gestion_bibliotheque.entity.Utilisateur;
import com.example.gestion_bibliotheque.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;

    @Autowired
    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public List<Emprunt> findAll() {
        return empruntRepository.findAll();
    }

    public List<Emprunt> findAllByUtilisateur(Utilisateur utilisateur) {
        return empruntRepository.findAllByUtilisateur(utilisateur);
    }

    public Emprunt findById(Integer id) {
        return empruntRepository.findById(id).orElse(null);
    }

    public Emprunt createOrUpdate(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

}
