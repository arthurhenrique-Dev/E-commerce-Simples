package Application.Ports.Out;

import Domain.Entities.Products.Category;
import Domain.Entities.Products.Product;
import Domain.ValueObjects.Price;
import Domain.ValueObjects.Quantity;
import Domain.ValueObjects.ValidText;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {

    void saveProduct(Product product);
    void applyDiscount(DTODiscount discount);
    void applyDiscountToList(DTODiscountToList discountToList);
    void updateProduct();
    void deleteProduct(Long id);
    List<Product> normalFindAllProducts();
    List<Product> normalFindAllProductsByName(String name);
    List<Product> normalFindAllProductsByCategory(List<Category> category);
    List<Product> normalFindProductById(Long id);
    List<Product> findAllProducts();
    List<Product> findAllProductsByName(String name);
    List<Product> findAllProductsByCategory(List<Category> category);
    List<Product> findProductById(Long id);

}
