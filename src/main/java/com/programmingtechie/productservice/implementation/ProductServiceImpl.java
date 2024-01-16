package com.programmingtechie.productservice.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import com.programmingtechie.productservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductRepository productRepository; 
    
	@Override
    public void createProduct(ProductRequest productRequest){

        // Create a new instance of the product object using the Builder pattern
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        // Save the product to the repository
        productRepository.save(product);

        // Log a message indicating that the product is saved
        log.info("Product {} is saved", product.getId());
    }

	@Override
    public List<ProductResponse> getAllProducts(){

        // Retrieve a list of all products from the repository
        List<Product> products = productRepository.findAll();

        // Map each Product entity to a ProductResponse and collect the results into a List
        return products.stream().map(this::mapToProductResponse).toList();

    }

    /**
     * This private method maps a Product entity to a ProductResponse DTO.
     * @param product
     * @return
     */
    private ProductResponse mapToProductResponse(Product product){

        // Create and return a ProductResponse using the Builder pattern
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }
}
