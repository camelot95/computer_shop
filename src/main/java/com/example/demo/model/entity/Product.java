package com.example.demo.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private String manufacturer;

    private Double price;

    private Integer count;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdditionalProperty> additionalProperties;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductType productType;
}
