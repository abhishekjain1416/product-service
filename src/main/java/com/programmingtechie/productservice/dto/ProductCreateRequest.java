package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class ProductCreateRequest {
    @NotBlank
    private String name;
    private String description;
    @Positive
    private BigDecimal price;
}
