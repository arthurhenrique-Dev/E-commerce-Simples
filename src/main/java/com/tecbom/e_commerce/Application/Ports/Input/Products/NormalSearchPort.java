package com.tecbom.e_commerce.Application.Ports.Input.Products;

import com.tecbom.e_commerce.Application.DTOs.Products.DTOReturnNormalProduct;
import com.tecbom.e_commerce.Application.DTOs.Products.DTOSearchProduct;

import java.util.List;

public interface NormalSearchPort {

    List<DTOReturnNormalProduct> searchProducts(DTOSearchProduct dtoSearchProduct);
}
