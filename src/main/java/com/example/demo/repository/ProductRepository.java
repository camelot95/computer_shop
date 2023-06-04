package com.example.demo.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join ProductType  pt on pt.id = p.productType.id where pt.value = :productType")
    List<Product> findAllByProductType(@Param("productType") String someStr);

    Optional<Product> findBySerialNumber(String serialNumber);
}
