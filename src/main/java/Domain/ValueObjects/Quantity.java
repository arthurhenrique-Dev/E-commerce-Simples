package Domain.ValueObjects;

import Domain.Exceptions.Exceptions.InvalidDataException;

public record Quantity(Integer quantity) {

    public Quantity(Integer quantity) {
        if (quantity >= 0) this.quantity = quantity;
        else throw new InvalidDataException();
    }
}
