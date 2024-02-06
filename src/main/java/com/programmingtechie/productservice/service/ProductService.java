package com.programmingtechie.productservice.service;

import org.springframework.stereotype.Service;

import com.programmingtechie.productservice.dto.ProductCreateRequest;
import com.programmingtechie.productservice.dto.ProductCreateResponse;
import com.programmingtechie.productservice.dto.ProductListResponse;

@Service
public interface ProductService {
    
	ProductCreateResponse createProduct(ProductCreateRequest productRequest);

    ProductListResponse getAllProducts();
}
