package com.programmingtechie.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;

@Service
public interface ProductService {
    
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
