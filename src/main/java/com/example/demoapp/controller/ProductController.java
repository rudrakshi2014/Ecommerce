package com.example.demoapp.controller;

import com.example.demoapp.model.Category;
import com.example.demoapp.model.Product;
import com.example.demoapp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    // DEPENDENCY INJECTION
    public ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //    Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //    Get a single product
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    //    Add new product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    //    Update a product
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    //    Delete a product
    @DeleteMapping("products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long productId) {
        return productService.deleteProduct(productId);
    }
}
