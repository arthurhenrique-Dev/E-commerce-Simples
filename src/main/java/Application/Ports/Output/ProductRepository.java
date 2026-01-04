package Application.Ports.Output;

import Application.DTO.Products.DTODiscount;
import Application.DTO.Products.DTODiscountToList;
import Application.DTO.Products.DTOSearchProduct;
import Domain.Entities.Products.Product;

import java.util.List;

public interface ProductRepository {

    void saveProduct(Product product);
    void applyDiscount(DTODiscount discount);
    void applyDiscountToList(DTODiscountToList discountToList);
    void updateProduct();
    List<Product> adminSearchProducts(DTOSearchProduct dtoSearchProduct);
    List<Product> searchProducts(DTOSearchProduct dtoSearchProduct);
}
