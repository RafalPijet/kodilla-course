package com.kodilla.good.patterns.onlineshop;

import java.util.List;

public class Transaction {

    private Provider provider;
    private List<Product> products;
    private boolean isCompleted;

    public Transaction(final Provider provider, final List<Product> products, final boolean isCompleted) {
        this.provider = provider;
        this.products = products;
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
