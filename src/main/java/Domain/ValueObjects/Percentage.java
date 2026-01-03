package Domain.ValueObjects;

import Domain.Exceptions.Exceptions.InvalidDataException;

public record Percentage(Integer percentage) {

    public Percentage(Integer percentage) {
        if (percentage < 0 || percentage > 100) this.percentage = percentage;
        else throw new InvalidDataException();
    }
}
