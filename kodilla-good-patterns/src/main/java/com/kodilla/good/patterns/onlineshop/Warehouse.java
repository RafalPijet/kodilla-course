package com.kodilla.good.patterns.onlineshop;

public class Warehouse implements InformationService {

    public Warehouse() {
        sendInfo();
    }

    public void sendInfo() {
        System.out.println();
        System.out.println("Dokument PZ został wysłany do Magazynu głównego");
    }
}
