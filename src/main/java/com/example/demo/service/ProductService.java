package com.example.demo.service;

import com.example.demo.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto);

    ProductDto update(ProductDto productDetails);

    ProductDto getById(Long id);

    List<ProductDto> findAllByProductType(String productType);
}