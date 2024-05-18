package com.example.demoapp.dto;

import com.example.demoapp.model.Category;
import com.example.demoapp.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category c = new Category();
        c.setTitle(category);
        product.setCategory(c);
        return product;
    }

    public String toString() {
        return "FakeStoreProductDto {" +
                "id = " + id +
                ", title = " + title +
                ", description = " + description +
                ", price = " + price +
                ", image = " + image +
                ", category = " + category +
                "}";
    }
}
