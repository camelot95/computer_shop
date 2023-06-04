package com.example.demo.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    List<Product> findAllByType(String type);

    @Query(name = "SELECT * FROM Product p JOIN FETCH p.productType WHERE p.id =: id", nativeQuery = true)
    Optional<Product> findById(Long id);




    Optional<Product> findBySerialNumber(String serialNumber);
}
