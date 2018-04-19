package com.kodilla.good.patterns.challenges;

public class StationaryShop implements TakeOrder {

    @Override
    public Order createOrder() {
        Order order = new Order();
        order.addPosition(new Product(3360, "Ekierka", "Biurowe"), 15);
        order.addPosition(new Product(5623, "Lamka biurkowa AcF10", "Oświetlenie"), 2);
        order.addPosition(new Product(2365, "Banany BIO", "Owoce"), 13);
        order.addPosition(new Product(8564, "Płyn do spryskiwacza", "Chemia"), 10);
        return order;
    }

}
