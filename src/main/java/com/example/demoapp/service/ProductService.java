package com.example.demoapp.service;

import com.example.demoapp.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    //    Get all products
    List<Product> getAllProducts();

    //    Get a single product
    Product getSingleProduct(Long productId);

    //    Add new product
    Product createProduct(Product product);

    //    Update a product
    Product updateProduct(Product product, Long productId);

    //    Delete a product
    ResponseEntity deleteProduct(Long productId);
}
