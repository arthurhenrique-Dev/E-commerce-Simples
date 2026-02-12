package com.tecbom.e_commerce.Domain.ValueObjects;

import com.tecbom.e_commerce.Domain.Exceptions.Exceptions.InvalidDataException;

public record Name(String name) {

    public Name(String name) {
        if (name != null && name.matches("^[\\p{L} ]{2,250}+$")) this.name = name;
        else throw new InvalidDataException("Nome invalido");
    }
}
