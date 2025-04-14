package com.example.gestion_bibliotheque.repository;

import com.example.gestion_bibliotheque.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {

    Auteur findByNom(String nom);
}
