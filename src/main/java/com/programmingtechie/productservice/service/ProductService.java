package com.programmingtechie.productservice.service;

import org.springframework.stereotype.Service;

import com.programmingtechie.productservice.dto.ProductListResponse;
import com.programmingtechie.productservice.dto.ProductRequest;

@Service
public interface ProductService {
    
    void createProduct(ProductRequest productRequest);

    ProductListResponse getAllProducts();
}
