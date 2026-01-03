package Application.DTO.Products;

import Domain.ValueObjects.Price;
import Domain.ValueObjects.Quantity;
import Domain.ValueObjects.ValidText;

import java.math.BigDecimal;
import java.util.List;

public record DTOUpdateProducts(

        Long id,
        Integer idxModel,
        ValidText name,
        Price price,
        Quantity quantity,
        List<String> photos,
        BigDecimal discountPercentage
) {
}
