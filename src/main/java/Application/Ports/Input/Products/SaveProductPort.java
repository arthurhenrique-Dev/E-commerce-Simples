package Application.Ports.Input.Products;

import Application.DTOs.Products.DTOSaveProduct;

public interface SaveProductPort {

    void saveProduct(DTOSaveProduct dtoSaveProduct);
}
