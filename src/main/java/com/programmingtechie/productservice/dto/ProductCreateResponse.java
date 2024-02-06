package com.programmingtechie.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateResponse extends ParentResponse {

	@JsonProperty("lc")
	private ProductCreate content;
}
