package com.kodilla.good.patterns.challenges;

public class Product {

    private int id;
    private String nameOfProduct;
    private String category;

    public Product(int id, String nameOfProduct, String category) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return  "id = " + id + ", " + nameOfProduct.toUpperCase() + ", " + category;
    }
}
