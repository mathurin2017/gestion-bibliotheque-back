package com.example.gestion_bibliotheque.repository;

import com.example.gestion_bibliotheque.entity.Auteur;
import com.example.gestion_bibliotheque.entity.Categorie;
import com.example.gestion_bibliotheque.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

    Livre findByTitre(String titre);

    List<Livre> findAllByAuteur(Auteur auteur);

    List<Livre> findAllByCategories(List<Categorie> categories);

}
