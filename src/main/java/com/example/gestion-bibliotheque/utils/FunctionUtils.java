package com.example.gestion_bibliotheque.utils;

import com.example.gestion_bibliotheque.exception.InvalidParameterException;

public class FunctionUtils {

    public static void validateId(int id) {
        if (id <= 0) throw new InvalidParameterException("The provided ID " + id + " is invalid. ID must be a positive non-zero integer.");
    }
}
