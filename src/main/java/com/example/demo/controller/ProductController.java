package com.example.demo.controller;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return productService.register(productDto);
    }

    @ApiOperation("Редактирование товара")
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @ApiParam(
                    value = "Новые данные по товару",
                    required = true
            )
            @PathVariable(value = "id") Long id, @Valid @RequestBody ProductDto productDetails) {

        return ResponseEntity.ok(productService.update(id, productDetails));
    }

//    @ApiOperation("Просмотр всех существующих товаров по типу")
//    @GetMapping
//    public ResponseEntity<List<ProductDto>> getByType(
//            @ApiParam(
//                    value = "Тип товара",
//                    required = true
//            )
//            @RequestHeader("type") String type) {
//        return ResponseEntity.ok(productService.findAllByType(type));
//    }

    @ApiOperation("Просмотр товара по идентификатору")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(
            @ApiParam(
                    value = "Идентификатор товара",
                    required = true
            ) @PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }
}