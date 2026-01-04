package Application.DTO.Products;

import java.math.BigDecimal;
import java.util.List;

public record DTODiscountToList(

        List<Long> ids,
        BigDecimal discountPercentage
) {
}
