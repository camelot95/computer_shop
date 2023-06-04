package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@ApiModel(description = "Тип товара")
@Data
public class ProductTypeDto {

    @JsonIgnore
    private Long id;

    @ApiModelProperty(
            notes = "Тип товара",
            name = "type",
            example = "Монитор"
    )
    @NotBlank
    private String value;

    @JsonIgnore
    private List<ProductDto> products;
}
