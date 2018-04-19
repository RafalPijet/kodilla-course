package com.kodilla.good.patterns.challenges;

public class CourierUPS implements DeliveryOfProducts {

    @Override
    public void sendOrder(CustomerOrder customerOrder) {
        System.out.println("Zamówienie dla klienta: " + customerOrder.getCustomer().getName() + " " + customerOrder.getCustomer().getSurname());
        System.out.println("zostało wysłane kurierem UPS");;
    }

}
