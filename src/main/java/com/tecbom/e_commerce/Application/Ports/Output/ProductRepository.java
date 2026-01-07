package com.tecbom.e_commerce.Application.Ports.Output;

import com.tecbom.e_commerce.Application.DTOs.Products.DTOSearchProduct;
import com.tecbom.e_commerce.Domain.Entities.Products.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    void saveProduct(Product product);

    List<Product> adminSearchProducts(DTOSearchProduct dtoSearchProduct);

    List<Product> searchProducts(DTOSearchProduct dtoSearchProduct);

    Optional<Product> checkProductById(UUID id);
}
