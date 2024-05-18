package com.example.demoapp.service;

import com.example.demoapp.model.Category;

import java.util.List;

public interface CategoryService {
    //    Get all categories
    List<Category> getAllCategory();
    //    Get in category
    List<Category> getInCategory(String categoryName);
}
