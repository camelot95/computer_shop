package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AdditionalProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "additionalProperty",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<AdditionalPropertyValue> additionalPropertyValues;
}
