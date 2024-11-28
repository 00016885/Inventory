package com.example.inventory.model;

public class Product {
    private String name;
    private Integer stock;

    public Product(String name, Integer stock) {
        this.name = name;
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
