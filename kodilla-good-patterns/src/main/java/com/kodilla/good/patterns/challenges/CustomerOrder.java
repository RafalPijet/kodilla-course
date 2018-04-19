package com.kodilla.good.patterns.challenges;

public class CustomerOrder {

    private Customer customer;
    private Order order;

    public CustomerOrder(final Customer customer, final Order order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return customer.getName() + " " + customer.getSurname() + " --> " + order.getOrdersMap();
    }
}
