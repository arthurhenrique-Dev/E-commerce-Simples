package Domain.ValueObjects;

import Domain.Exceptions.Exceptions.InvalidDataException;

import java.math.BigDecimal;

public record Price(BigDecimal price) {

    private BigDecimal validatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) throw new InvalidDataException("Preço não pode ser menor que zero");
        if (price.scale() != 2) price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        return price;
    }

    public Price(BigDecimal price) {
        this.price = validatePrice(price);
    }

    public Price add(Price other) {
        return new Price(this.price.add(other.price));
    }

    public Price discount(BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.ZERO) < 0 || percentage.compareTo(new BigDecimal("100")) > 0) {
            throw new InvalidDataException("Percentual de desconto inválido");
        }
        BigDecimal discountAmount = this.price.multiply(percentage).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
        return new Price(this.price.subtract(discountAmount));
    }
}
