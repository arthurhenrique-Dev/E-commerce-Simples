package Application.Ports.Input.Products;

import Application.DTOs.Products.DTODeleteModel;

public interface DeleteModelPort {

    void deleteModel(DTODeleteModel dtoDeleteModel);
}
