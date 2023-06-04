package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@ApiModel(description = "Товар")
@Data
public class AdditionalPropertyValueDto {

    @JsonIgnore
    private Long id;

    @ApiModelProperty(
            notes = "Наименование",
            name = "value",
            example = "17"
    )
    @NotBlank
    private String value;

    @ApiModelProperty(
            notes = "Значение",
            name = "additionalProperty",
            example = "Диагональ"
    )
    private AdditionalPropertyDto additionalProperty;

    @JsonIgnore
    private List<ProductDto> products;
}
