package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String name;
    private String description;
    private BigDecimal price;
}
