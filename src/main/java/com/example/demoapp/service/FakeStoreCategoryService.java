package com.example.demoapp.service;

import com.example.demoapp.dto.FakeStoreCategoryDto;
import com.example.demoapp.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService {
    // DEPENDENCY INJECTION
    public RestTemplate restTemplate;
    public FakeStoreCategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //    Get all categories
    @Override
    public List<Category> getAllCategory() {
        List allCategories = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                List.class
        );
        System.out.println(allCategories);
        return allCategories;
    }

    //    Get in category
    @Override
    public List<Category> getInCategory(String categoryName) {
        List category = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/" + categoryName,
                List.class
        );
        System.out.println(category.toString());
        return category;
    }
}
