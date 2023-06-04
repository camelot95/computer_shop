package com.example.demo.service;

import com.example.demo.configuration.OrikaMapperConfig;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UniquenessException;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import com.example.demo.repository.AdditionalPropertyRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductTypeRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final AdditionalPropertyRepository additionalPropertyRepository;
    private final MapperFacade mapperFacade = new OrikaMapperConfig();

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductTypeRepository productTypeRepository, AdditionalPropertyRepository additionalPropertyRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.additionalPropertyRepository = additionalPropertyRepository;
    }

    @Override
    @Transactional
    public ProductDto create(ProductDto productDto) {
        Product product = mapperFacade.map(productDto, Product.class);
        checkUniqueSerialNumber(product);
        Product savedProduct = productRepository.save(new Product());
        product.setId(savedProduct.getId());
        return mapperFacade.map(productRepository.save(checkAndSetRecord(product)), ProductDto.class);
    }

    @Override
    @Transactional
    public ProductDto update(ProductDto productDetails) {
        Long productId = productDetails.getId();
        productRepository.findById(productId).orElseThrow(() -> new NotFoundException("product with id=" + productId + "was not found"));
        additionalPropertyRepository.deleteAllByProductId(productId);
        Product inputProduct = mapperFacade.map(productDetails, Product.class);

        return mapperFacade.map(productRepository.save(checkAndSetRecord(inputProduct)), ProductDto.class);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("product with id=" + id + "was not found"));

        return mapperFacade.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> findAllByProductType(String productType) {
        List<ProductDto> productList = mapperFacade.mapAsList(productRepository.findAllByProductType(productType), ProductDto.class);

        return productList;
    }

    private Product checkAndSetRecord(Product product) {
        ProductType productTypeInput = product.getProductType();
        ProductType productType = productTypeRepository.findByValue(productTypeInput.getValue()).orElse(productTypeInput);
        product.setProductType(productType);

        product.getAdditionalProperties()
                .forEach(x -> x.setProduct(product));

        return product;
    }

    private void checkUniqueSerialNumber(Product product) {
        if (productRepository.findBySerialNumber(product.getSerialNumber()).isPresent()) {
            throw new UniquenessException("Non-unique serial number for the product");
        }
    }
}