package com.programmingtechie.productservice.enums;

import com.programmingtechie.productservice.errors.ProductState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductEnum {

    PRODUCTS_FETCHED_SUCCESSFULLY(ProductState.PRODUCTS_LIST_FETCHED_MESSAGE, ProductState.PRODUCTS_LIST_FETCHED_CODE),
    PRODUCT_CREATED_SUCCESSFULLY(ProductState.PRODUCT_CREATED_SUCCESS_MESSAGE, ProductState.PRODUCT_CREATED_SUCCESS_CODE),
    INVALID_ARGUMENTS(ProductState.INVALID_ARGUMENTS_MESSAGE, ProductState.INVALID_ARGUMENTS_CODE);

    private final String message;
    private final String code;

    public String getSuccessCode() {
        return "S16" + code;
    }

    public String getErrorCode() {
        return "E16" + code;
    }
}
