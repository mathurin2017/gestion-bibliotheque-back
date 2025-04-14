package com.example.gestion_bibliotheque.repository;

import com.example.gestion_bibliotheque.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByNom(String nom);

    Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
}
