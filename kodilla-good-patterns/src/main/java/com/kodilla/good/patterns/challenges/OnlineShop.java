package com.kodilla.good.patterns.challenges;

public class OnlineShop implements TakeOrder {

    @Override
    public Order createOrder() {
        Order order = new Order();
        order.addPosition(new Product(2254, "Kalafior", "Warzywa"), 10);
        order.addPosition(new Product(5623, "Power Bank", "Akcesoria"), 5);
        order.addPosition(new Product(2365, "Zeszyt A5 linia", "Biurowe"), 23);
        order.addPosition(new Product(8564, "Kinkiet ścienny 6x3", "Oświetlenie"), 1);
        return order;
    }
}
