package com.programmingtechie.productservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.List;

@Setter
public class ErrorListResponse extends ParentResponse {

    @JsonProperty("err")
    private List<ErrorResponse> errors;
}
