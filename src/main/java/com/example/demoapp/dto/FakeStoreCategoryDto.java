package com.example.demoapp.dto;

import com.example.demoapp.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCategoryDto {
    private long id;
    private String title;

    public Category toCategory() {
        Category cat = new Category();
        cat.setId(id);
        cat.setTitle(title);
        return cat;
    }

    public String toString() {
        return "FakeStoreCategoryDto {" +
                "id = " + id +
                ", title = " + title +
                "}";
    }
}
