package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AdditionalPropertyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private AdditionalProperty additionalProperty;

    @ManyToMany(
//            mappedBy = "additionalPropertyValues",
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            }
    )
    private List<Product> products;
}