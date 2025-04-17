package com.example.gestion_bibliotheque.entity;

import com.example.gestion_bibliotheque.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String email;

    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Timestamp dateCreation;

    @PrePersist
    protected void onCreate() {
        this.dateCreation = new Timestamp(System.currentTimeMillis());
    }

}
