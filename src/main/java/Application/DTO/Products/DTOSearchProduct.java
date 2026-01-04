package Application.DTO.Products;

import Domain.Entities.Products.Category;
import Domain.ValueObjects.Price;
import Domain.ValueObjects.ValidText;

public record DTOSearchProduct(

        ValidText name,
        Long id,
        Category category,
        Price price,
        OrderBy orderBy
) {
}
