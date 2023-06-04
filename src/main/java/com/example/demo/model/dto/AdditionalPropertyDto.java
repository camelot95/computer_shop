package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@ApiModel(description = "Товар")
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

    @JsonIgnore
    private List<AdditionalPropertyValueDto> additionalPropertyValues;
}
