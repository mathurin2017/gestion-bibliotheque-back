package com.example.gestion_bibliotheque.security;

import com.example.gestion_bibliotheque.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) throw new UsernameNotFoundException("User not found with email: " + email);

        return new User(
                utilisateur.getEmail(),
                utilisateur.getMotDePasse(),
                Collections.singleton(new SimpleGrantedAuthority(utilisateur.getRole().toString()))
        );
    }
}
