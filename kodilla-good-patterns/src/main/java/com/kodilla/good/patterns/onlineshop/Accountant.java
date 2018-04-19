package com.kodilla.good.patterns.onlineshop;

public class Accountant implements InformationService {

    public Accountant() {
        sendInfo();
    }

    public void sendInfo() {
        System.out.println();
        System.out.println("Specyfikacja zamówienia została przesłana do Działu Księgowości");
    }
}
