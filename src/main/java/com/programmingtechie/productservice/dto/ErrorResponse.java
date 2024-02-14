package com.programmingtechie.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ErrorResponse {

    @JsonProperty("di")
    private String debugId;

    @JsonProperty("em")
    private String errorMessage;
}
