package com.example.gestion_bibliotheque.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "livres")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_auteur", nullable = true)
    private Auteur auteur;

    private Integer anneePublication;

    private Boolean disponible;

    private Timestamp dateAjout;

    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprunt> emprunts;

    @ManyToMany
    @JoinTable(
            name = "livre_categorie",
            joinColumns = @JoinColumn(name = "id_livre"),
            inverseJoinColumns = @JoinColumn(name = "id_categorie")
    )
    private List<Categorie> categories;

}
