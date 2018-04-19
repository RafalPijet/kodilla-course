package com.kodilla.good.patterns.challenges;

public class SendSMS implements InformationService {

    @Override
    public void sendInfo(CustomerOrder customerOrder) {
        System.out.println("Potwierdzenie realizacji zamówienia wysłano na numer: " + customerOrder.getCustomer().getPhoneNumber());
    }
}
