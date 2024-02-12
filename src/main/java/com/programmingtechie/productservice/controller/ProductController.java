package com.programmingtechie.productservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechie.productservice.dto.ProductCreateRequest;
import com.programmingtechie.productservice.dto.ProductCreateResponse;
import com.programmingtechie.productservice.dto.ProductListResponse;
import com.programmingtechie.productservice.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreateResponse createProduct(@Valid @RequestBody ProductCreateRequest request){

        ProductCreateResponse response = productService.createProduct(request);
    	return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductListResponse getAllProducts(){
        return productService.getAllProducts();
    }
}
