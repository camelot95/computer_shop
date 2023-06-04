package com.example.demo.service;

import com.example.demo.configuration.OrikaMapperConfig;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UniquenessException;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductTypeRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final MapperFacade mapperFacade = new OrikaMapperConfig();

    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public ProductDto register(ProductDto productDto) {

        Product product = mapperFacade.map(productDto, Product.class);

        return mapperFacade.map(productRepository.save(checkRecord(product)), ProductDto.class);
    }

    public ProductDto update(Long id, ProductDto productDetails) {

        Product product = mapperFacade.map(getById(id), Product.class);

        ProductType productType = product.getProductType();

        ProductType inputProductType = mapperFacade.map(productDetails.getProductType(),ProductType.class);
        productType.setValue(inputProductType.getValue());
        productType.setProducts(inputProductType.getProducts());

        product.setProductType(productType);


        product.setCount(productDetails.getCount());
        product.setPrice(productDetails.getPrice());
        product.setManufacturer(productDetails.getManufacturer());
        product.setSerialNumber(productDetails.getSerialNumber());


        final Product updatedUser = productRepository.save(product);

        return mapperFacade.map(updatedUser, ProductDto.class);

    }

    public ProductDto getById(Long id) {
//        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("product with id=" + id + "was not found"));

        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("product with id=" + id + "was not found"));

        return mapperFacade.map(product, ProductDto.class);
    }

//    public List<ProductDto> findAllByType(String type) {
//        List<Product> productList = productRepository.findAllByType(type);
//
//        return mapperFacade.mapAsList(productList, ProductDto.class);
//    }

    private Product checkRecord(Product product) {

        if (productRepository.findBySerialNumber(product.getSerialNumber()).isPresent()) {
            throw new UniquenessException("Non-unique serial number for the product");
        }

        Optional<ProductType> optionalProductType = productTypeRepository.findByValue(product.getProductType().getValue());

        if (optionalProductType.isPresent()) {
            product.setProductType(optionalProductType.get());
        }

        return product;
    }
}