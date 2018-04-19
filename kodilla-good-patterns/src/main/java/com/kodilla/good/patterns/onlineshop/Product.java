package com.kodilla.good.patterns.onlineshop;

import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private String category;
    private String description;
    private int quantity;

    public Product(final int id, final String name, final String category, final String description, final int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    @Override
    public String toString() {
        return  "ilość: " + quantity + " --> " + name.toUpperCase() + " [" + category + "] , " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
