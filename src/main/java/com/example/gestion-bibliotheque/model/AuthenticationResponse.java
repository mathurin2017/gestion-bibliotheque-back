package com.example.gestion_bibliotheque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {

    private String accessToken;
    private String refreshToken;
}
