package com.tecbom.e_commerce.Application.UseCases.Products;

import com.tecbom.e_commerce.Application.DTOs.Products.DTOSearchProduct;
import com.tecbom.e_commerce.Application.Ports.Input.Products.AdminSearchPort;
import com.tecbom.e_commerce.Application.Ports.Output.ProductRepository;
import com.tecbom.e_commerce.Domain.Entities.Products.Product;

import java.util.List;

public class AdminSearchUseCase implements AdminSearchPort {

    private final ProductRepository repository;

    public AdminSearchUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> searchProducts(DTOSearchProduct dtoSearchProduct) {
        return repository.adminSearchProducts(dtoSearchProduct);
    }
}
