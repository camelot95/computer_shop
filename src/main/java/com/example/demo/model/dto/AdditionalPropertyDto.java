package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "Дополнительное свойство")
@Data
public class AdditionalPropertyDto {

    @JsonIgnore
    private Long id;

    @ApiModelProperty(
            notes = "Наименование",
            name = "name",
            example = "Диагональ"
    )
    @NotBlank
    private String name;

    @ApiModelProperty(
            notes = "Значение",
            name = "value",
            example = "17"
    )
    @NotBlank
    private String value;

    @JsonIgnore
    private ProductDto product;
}
