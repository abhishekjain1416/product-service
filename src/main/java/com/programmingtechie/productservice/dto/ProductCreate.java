package com.programmingtechie.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class ProductCreate {

	@JsonProperty("id")
	private String id;
}
