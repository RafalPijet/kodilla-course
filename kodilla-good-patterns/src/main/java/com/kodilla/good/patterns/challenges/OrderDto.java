package com.kodilla.good.patterns.challenges;

import java.util.Map;

public class OrderDto {

    private Customer customer;
    private Order order;
    private boolean isCompleted;

    public OrderDto(final Customer customer, final Order order, final boolean isCompleted) {
        this.customer = customer;
        this.order = order;
        this.isCompleted = isCompleted;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        String result = null;
        for (Map.Entry entry : order.getOrdersMap().entrySet()) {
            result = entry.getKey().toString() + "ilość: " + entry.getValue().toString() + "\n";

        }
        return result;
    }
}
