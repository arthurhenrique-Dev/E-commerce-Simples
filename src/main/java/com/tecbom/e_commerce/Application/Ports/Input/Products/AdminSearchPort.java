package com.tecbom.e_commerce.Application.Ports.Input.Products;

import com.tecbom.e_commerce.Application.DTOs.Products.DTOSearchProduct;
import com.tecbom.e_commerce.Domain.Entities.Products.Product;

import java.util.List;

public interface AdminSearchPort {

    List<Product> searchProducts(DTOSearchProduct dtoSearchProduct);
}
