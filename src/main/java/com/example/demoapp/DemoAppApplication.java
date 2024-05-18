package com.example.demoapp;

import com.example.demoapp.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

    public static void main(String[] args) {
        Product p = new Product();
        p.setTitle("test");
        SpringApplication.run(DemoAppApplication.class, args);
    }

}
