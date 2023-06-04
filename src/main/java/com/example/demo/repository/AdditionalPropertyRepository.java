package com.example.demo.repository;

import com.example.demo.model.entity.AdditionalProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalPropertyRepository extends JpaRepository<AdditionalProperty, Long> {

    void deleteAllByProductId(Long productId);
}