package com.example.demo.controller;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@Api("/products")
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @ApiOperation("Добавление товара")
    @PostMapping("/create")
    public ProductDto register(
            @ApiParam(
                    value = "Новый товар",
                    required = true
            ) @Valid @RequestBody ProductDto productDto) {

        return productService.create(productDto);
    }

    @ApiOperation("Редактирование товара")
    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(
            @ApiParam(
                    value = "Новые данные по товару",
                    required = true
            )
            @Valid @RequestBody ProductDto productDetails) {

        return ResponseEntity.ok(productService.update(productDetails));
    }

    @ApiOperation("Просмотр товара по идентификатору")
    @GetMapping("/id")
    public ResponseEntity<ProductDto> getById(
            @ApiParam(
                    value = "Идентификатор товара",
                    required = true
            ) @PathVariable Long id) {

        return ResponseEntity.ok(productService.getById(id));
    }

    @ApiOperation("Просмотр товара по типу")
    @GetMapping("/type/{productType}")
    public ResponseEntity<List<ProductDto>> getByProductType(
            @ApiParam(
                    value = "Тип товара",
                    required = true
            ) @PathVariable String productType) {

        return ResponseEntity.ok(productService.findAllByProductType(productType));
    }
}