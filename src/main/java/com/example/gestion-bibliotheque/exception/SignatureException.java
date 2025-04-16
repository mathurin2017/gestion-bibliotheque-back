package com.example.gestion_bibliotheque.exception;

import io.jsonwebtoken.security.SecurityException;

public class SignatureException extends SecurityException {
    public SignatureException(String message) {
        super(message);
    }
}
