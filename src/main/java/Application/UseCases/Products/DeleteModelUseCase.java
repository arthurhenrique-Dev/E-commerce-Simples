package Application.UseCases.Products;

import Application.DTOs.Products.DTODeleteModel;
import Application.Ports.Input.Products.DeleteModelPort;
import Application.Ports.Output.ProductRepository;
import Domain.Entities.Products.Product;
import Domain.Exceptions.Exceptions.ProductNotFoundException;

public class DeleteModelUseCase implements DeleteModelPort {

    private final ProductRepository repository;

    public DeleteModelUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteModel(DTODeleteModel dtoSpecific) {
        Product product = repository.checkProductById(dtoSpecific.id())
                .orElseThrow(() -> new ProductNotFoundException());
        product.DeleteModel(dtoSpecific.idxModel());
        repository.saveProduct(product);
    }
}
