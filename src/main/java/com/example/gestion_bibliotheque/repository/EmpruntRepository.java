package com.example.gestion_bibliotheque.repository;

import com.example.gestion_bibliotheque.entity.Emprunt;
import com.example.gestion_bibliotheque.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

    List<Emprunt> findAllByUtilisateur(Utilisateur utilisateur);
}
