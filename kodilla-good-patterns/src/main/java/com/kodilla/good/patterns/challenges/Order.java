package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private HashMap<Product, Integer> ordersMap = new HashMap<>();

    public void addPosition(Product product, int quantity) {
        ordersMap.put(product, quantity);
    }

    public HashMap<Product, Integer> getOrdersMap() {
        return ordersMap;
    }

    public void showOrder() {
        for (Map.Entry entry : ordersMap.entrySet()) {
            System.out.println(entry.getKey() + ", ilość: " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return ": " + ordersMap;
    }
}
