package com.example.gestion_bibliotheque.controller;

import com.example.gestion_bibliotheque.exception.AuthenticationException;
import com.example.gestion_bibliotheque.exception.InvalidRefreshTokenException;
import com.example.gestion_bibliotheque.model.AuthenticationRequest;
import com.example.gestion_bibliotheque.model.AuthenticationResponse;
import com.example.gestion_bibliotheque.model.RefreshTokenRequest;
import com.example.gestion_bibliotheque.security.CustomUserDetailsService;
import com.example.gestion_bibliotheque.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
        try {
            final var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword());
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Incorrect email or password");
        }

        final var userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String accessToken = jwtUtil.generateAccessToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(accessToken, refreshToken));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) throws InvalidRefreshTokenException {
        final String refreshToken = refreshTokenRequest.getRefreshToken();
        final String email = jwtUtil.extractEmail(refreshToken);
        final var userDetails = customUserDetailsService.loadUserByUsername(email);

        if (!jwtUtil.validateToken(refreshToken, userDetails)) throw new InvalidRefreshTokenException("Invalid refresh token");

        String newAccessToken = jwtUtil.generateAccessToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(newAccessToken, refreshToken));
    }

}
