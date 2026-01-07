package Application.Ports.Input.Products;

import Application.DTOs.Products.DTODiscount;

public interface ApplyDiscountPort {

    void applyDiscount(DTODiscount dtoDiscount);
}
