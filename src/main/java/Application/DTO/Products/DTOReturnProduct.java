package Application.DTO.Products;

import Domain.Entities.Products.Category;
import Domain.Entities.Products.Rating;
import Domain.Entities.Products.Review;
import Domain.ValueObjects.Quantity;
import Domain.ValueObjects.ValidText;

import java.util.List;

public record DTOReturnProduct(

        Long id,
        ValidText name,
        ValidText description,
        Category category,
        List<DTOModel> models,
        Quantity quantity,
        Rating rating,
        List<Review> reviews
) {
}
