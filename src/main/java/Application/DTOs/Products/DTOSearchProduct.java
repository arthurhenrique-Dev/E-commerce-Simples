package Application.DTOs.Products;

import Domain.Entities.Products.Category;
import Domain.ValueObjects.Price;
import Domain.ValueObjects.ValidText;

import java.util.UUID;

public record DTOSearchProduct(

        String searchTerm,
        Integer idxModel,
        Category category,
        Price price,
        OrderBy orderBy
) {
}
