package Application.DTOs.Products;

import Domain.ValueObjects.Quantity;

import java.util.UUID;

public record DTORecordPurchase(

        UUID id,
        Integer idxModel,
        Integer quantity
) {
}
