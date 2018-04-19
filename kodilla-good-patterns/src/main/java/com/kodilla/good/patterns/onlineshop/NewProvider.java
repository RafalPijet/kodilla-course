package com.kodilla.good.patterns.onlineshop;

import java.util.ArrayList;
import java.util.List;

public class NewProvider implements Provider {

    private String name;
    private String address;
    private String email;
    private int phone;
    private String contactPerson;
    private List<Product> products;

    public NewProvider(final String name, final String address, final String email, final int phone, final String contactPerson, final List<Product> productList) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.contactPerson = contactPerson;
        this.products = productList;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void showOffer() {
        System.out.println("\nPanie PREZESIE, nowa firma: \n");
        System.out.println(this);
        System.out.println("\nskłada nam swoją ofertę:\n");
        products.stream()
                .forEach(product -> System.out.println(product));
        System.out.println();
    }

    @Override
    public String toString() {
        return "\"" + name + "\", " + address + ", " + email + ", " + phone + ", " + contactPerson;
    }

    @Override
    public List<Product> process() {
        System.out.println();
        System.out.println("Panie Prezesie, jako NOWY dostawca nasza firma:");
        System.out.println(this.getName() + ", " + this.getAddress());
        System.out.println();
        System.out.println("wykona dostawę następującego asortymentu:");
        System.out.println();
        this.products.stream()
                .forEach(System.out::println);
        return new ArrayList<>(this.products);
    }
}
