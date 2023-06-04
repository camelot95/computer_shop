package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @OneToMany(
            mappedBy = "productType",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Product> products;
}
