package com.example.demoapp.service;

import com.example.demoapp.dto.FakeStoreProductDto;
import com.example.demoapp.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    // DEPENDENCY INJECTION
    public RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //    Get all products
    @Override
    public List<Product> getAllProducts() {
        List productList = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                List.class
        );
        System.out.println(productList);
        return productList;
    }

    //    Get a single product
    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        System.out.println(fakeStoreProductDto.toString());
        return fakeStoreProductDto.toProduct();
    }

    //    Add new product
    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fspd = new FakeStoreProductDto();
        fspd.setTitle(product.getTitle());
        fspd.setDescription(product.getDescription());
        fspd.setPrice(product.getPrice());
        fspd.setCategory(product.getCategory().getTitle());
        fspd.setImage(product.getImageUrl());

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fspd,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    //    Update a product
    @Override
    public Product updateProduct(Product product, Long productId) {
        FakeStoreProductDto fspd = new FakeStoreProductDto();
        fspd.setTitle(product.getTitle());
        fspd.setDescription(product.getDescription());
        fspd.setPrice(product.getPrice());
        fspd.setCategory(product.getCategory().getTitle());
        fspd.setImage(product.getImageUrl());

        FakeStoreProductDto response = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/" + product.getId(),
                fspd,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    //    Delete a product
    @Override
    public ResponseEntity deleteProduct(Long productId) {
            restTemplate.delete("https://fakestoreapi.com/products/" + productId);
            return new ResponseEntity("Product deleted successfully with ID: " + productId, HttpStatus.OK);
    }
}
