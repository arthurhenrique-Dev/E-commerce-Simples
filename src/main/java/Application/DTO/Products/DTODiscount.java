package Application.DTO.Products;

import java.math.BigDecimal;

public record DTODiscount(

    Long id,
    BigDecimal discountPercentage
) {
}
