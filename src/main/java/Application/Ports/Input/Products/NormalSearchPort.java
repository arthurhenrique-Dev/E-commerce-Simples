package Application.Ports.Input.Products;

import Application.DTO.Products.DTOReturnProduct;
import Application.DTO.Products.DTOSearchProduct;

import java.util.List;

public interface NormalSearchPort {

    List<DTOReturnProduct> searchProducts(DTOSearchProduct dtoSearchProduct);
}
