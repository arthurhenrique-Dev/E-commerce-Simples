package Application.Ports.Input.Products;

import Application.DTOs.Products.DTOUpdateProduct;

public interface UpdateProductPort {

    void updateProduct(DTOUpdateProduct dtoUpdateProduct);
}
