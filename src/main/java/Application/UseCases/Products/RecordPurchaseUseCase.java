package Application.UseCases.Products;

import Application.DTOs.Products.DTORecordPurchase;
import Application.Ports.Input.Products.RecordPurchasePort;
import Application.Ports.Output.ProductRepository;
import Domain.Entities.Products.Product;
import Domain.Exceptions.Exceptions.ProductNotFoundException;

public class RecordPurchaseUseCase implements RecordPurchasePort {

    private final ProductRepository repository;

    public RecordPurchaseUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void RecordPurchase(DTORecordPurchase dtoRecordPurchase) {
        Product product = repository.checkProductById(dtoRecordPurchase.id())
                .orElseThrow(() -> new ProductNotFoundException());
        product.RegisterPurchase(dtoRecordPurchase.idxModel(), dtoRecordPurchase.quantity());
        repository.saveProduct(product);
    }
}
