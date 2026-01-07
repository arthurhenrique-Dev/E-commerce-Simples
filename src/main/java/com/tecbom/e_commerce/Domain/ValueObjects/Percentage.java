package com.tecbom.e_commerce.Domain.ValueObjects;

import com.tecbom.e_commerce.Domain.Exceptions.Exceptions.InvalidDataException;

public record Percentage(Integer percentage) {

    public Percentage(Integer percentage) {
        if (percentage < 0 || percentage > 100) this.percentage = percentage;
        else throw new InvalidDataException();
    }
}
