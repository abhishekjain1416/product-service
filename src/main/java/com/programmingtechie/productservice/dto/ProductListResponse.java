package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListResponse extends ParentResponse {
    
	@JsonProperty("lc")
    private List<ProductList> content;
}
