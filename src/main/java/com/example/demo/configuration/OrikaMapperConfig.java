package com.example.demo.configuration;

import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.dto.ProductTypeDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.entity.ProductType;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.MapperFactory;

public class OrikaMapperConfig extends ConfigurableMapper {
    protected void configure(MapperFactory factory) {

        factory.classMap(Product.class, ProductDto.class)
                .byDefault()
                .register();

        factory.classMap(ProductType.class, ProductTypeDto.class)
                .byDefault()
                .register();


    }
}
