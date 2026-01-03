package Application.DTO.Products;

import Domain.ValueObjects.Price;
import Domain.ValueObjects.Quantity;
import Domain.ValueObjects.ValidText;

import java.util.List;

public record DTOSaveProduct(

        ValidText name,
        Price price,
        Quantity quantity,
        List<String>photos,
        List<DTOSaveModel>models
) {
}
