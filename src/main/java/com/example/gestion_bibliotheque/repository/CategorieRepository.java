package com.example.gestion_bibliotheque.repository;

import com.example.gestion_bibliotheque.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Categorie findByNom(String nom);
}
