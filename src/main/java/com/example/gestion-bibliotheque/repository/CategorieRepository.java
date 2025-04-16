package com.example.gestion_bibliotheque.repository;

import com.example.gestion_bibliotheque.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Optional<Categorie> findByNom(String nom);
}
