package com.programmingtechie.productservice.implementation;

import java.util.List;

import com.programmingtechie.productservice.enums.ProductEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.programmingtechie.productservice.dto.ProductCreate;
import com.programmingtechie.productservice.dto.ProductCreateRequest;
import com.programmingtechie.productservice.dto.ProductCreateResponse;
import com.programmingtechie.productservice.dto.ProductList;
import com.programmingtechie.productservice.dto.ProductListResponse;
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
    public ProductCreateResponse createProduct(ProductCreateRequest productRequest){

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
        
        ProductCreate productCreated = ProductCreate.builder()
        	.id(product.getId())
        	.build();
        
        ProductCreateResponse response = new ProductCreateResponse();
        response.setMessageCode(ProductEnum.PRODUCT_CREATED_SUCCESSFULLY.getSuccessCode());
        response.setMessage(ProductEnum.PRODUCT_CREATED_SUCCESSFULLY.getMessage());
        response.setContent(productCreated);
        
        return response;
    }

	@Override
    public ProductListResponse getAllProducts(){

        // Retrieve a list of all products from the repository
        List<Product> products = productRepository.findAll();

        // Map each Product entity to a ProductResponse and collect the results into a List
        List<ProductList> productsList = products.stream().map(this::mapToProductResponse).toList();
        
        ProductListResponse response = new ProductListResponse();
        response.setMessageCode(ProductEnum.PRODUCTS_FETCHED_SUCCESSFULLY.getSuccessCode());
        response.setMessage(ProductEnum.PRODUCTS_FETCHED_SUCCESSFULLY.getMessage());
        response.setContent(productsList);
        
        return response;
    }

    /**
     * This private method maps a Product entity to a ProductResponse DTO.
     * @param product
     * @return
     */
    private ProductList mapToProductResponse(Product product){

        // Create and return a ProductResponse using the Builder pattern
        return ProductList.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }
}
