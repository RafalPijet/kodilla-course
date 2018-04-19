package com.kodilla.good.patterns.challenges;

public class SendEmail implements InformationService {

    @Override
    public void sendInfo(CustomerOrder customerOrder) {
        System.out.println("Potwierdzenie realizacji zamówienia wysłano na e-mail: " + customerOrder.getCustomer().getEmail());
    }
}
