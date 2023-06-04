package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@ApiModel(description = "Товар")
@Data
public class ProductDto {

    @JsonIgnore
    private Long id;

    @ApiModelProperty(
            notes = "Тип товара",
            name = "productType"
    )
    private ProductTypeDto productType;

    @ApiModelProperty(
            notes = "Серийный номер",
            name = "serialNumber",
            example = "LXJR00C029-55"
    )
    @NotBlank
    private String serialNumber;

    @ApiModelProperty(
            notes = "Производитель",
            name = "manufacturer",
            example = "Asus"
    )
    @NotBlank
    private String manufacturer;

    @ApiModelProperty(
            notes = "Цена",
            name = "price",
            example = "100.50"
    )
    @NotNull
    private Double price;

    @ApiModelProperty(
            notes = "Кол-во",
            name = "count",
            example = "10"
    )
    private Integer count;

    private List<AdditionalPropertyValueDto> additionalPropertyValues;
}
