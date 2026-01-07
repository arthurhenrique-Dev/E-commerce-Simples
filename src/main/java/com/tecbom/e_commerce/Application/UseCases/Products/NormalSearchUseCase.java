package com.tecbom.e_commerce.Application.UseCases.Products;

import com.tecbom.e_commerce.Application.DTOs.Products.DTOReturnNormalProduct;
import com.tecbom.e_commerce.Application.DTOs.Products.DTOSearchProduct;
import com.tecbom.e_commerce.Application.Mappers.ProductMapper;
import com.tecbom.e_commerce.Application.Ports.Input.Products.NormalSearchPort;
import com.tecbom.e_commerce.Application.Ports.Output.ProductRepository;

import java.util.List;

public class NormalSearchUseCase implements NormalSearchPort {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public NormalSearchUseCase(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DTOReturnNormalProduct> searchProducts(DTOSearchProduct dtoSearchProduct) {

        return repository.searchProducts(dtoSearchProduct)
                .stream()
                .map(mapper::toReturn)
                .toList();
    }
}
