package com.example.Product_Manage;

import java.io.Serializable;

public class ProductObject implements Serializable {
    String name,category,description;
    float price;

    public ProductObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductObject(String name, String category, float price, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
}
