package com.example.demo.repository;

import com.example.demo.model.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
//    List<Product> findAllByType(String type);

    Optional<ProductType> findByValue(String value);


}
