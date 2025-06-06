package com.example.gestion_bibliotheque.service;

import com.example.gestion_bibliotheque.entity.Livre;
import com.example.gestion_bibliotheque.exception.ResourceNotFoundException;
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

    public Livre findById(int id) {
        return livreRepository.findById(id).orElse(null);
    }

    public Livre createOrUpdate(Livre livre) {
        return livreRepository.save(livre);
    }

    public void delete(int id) throws ResourceNotFoundException {
        if (!livreRepository.existsById(id)) throw new ResourceNotFoundException("Livre with id " + id + " not found.");
        livreRepository.deleteById(id);
    }

}
