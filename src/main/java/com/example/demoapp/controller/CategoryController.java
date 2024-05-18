package com.example.demoapp.controller;

import com.example.demoapp.model.Category;
import com.example.demoapp.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    // DEPENDENCY INJECTION
    public CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //    Get all categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    //    Get in category
    @GetMapping("/categories/{name}")
    public List<Category> getInCategory(@PathVariable("name") String categoryName) {
        return categoryService.getInCategory(categoryName);
    }
}
