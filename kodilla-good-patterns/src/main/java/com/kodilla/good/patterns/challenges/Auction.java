package com.kodilla.good.patterns.challenges;

public class Auction implements TakeOrder {

    @Override
    public Order createOrder() {
        Order order = new Order();
        order.addPosition(new Product(9254, "Pomidor", "Warzywa"), 12);
        order.addPosition(new Product(5623, "Power Bank", "Akcesoria"), 15);
        order.addPosition(new Product(2365, "Zeszyt A5 linia", "Biurowe"), 93);
        order.addPosition(new Product(8564, "Kinkiet ścienny 6x3", "Oświetlenie"), 4);
        return order;
    }
}
