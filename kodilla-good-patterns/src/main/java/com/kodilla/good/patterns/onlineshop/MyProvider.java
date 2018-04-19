package com.kodilla.good.patterns.onlineshop;

import java.util.*;

public class MyProvider implements Provider {

    private String name;
    private String address;
    private String email;
    private int phone;
    private String contactPerson;
    private List<Product> products = new ArrayList<>();

    public MyProvider(final String name, final String address, final String email, final int phone, final String contactPerson) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.contactPerson = contactPerson;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "\"" + name + "\", " + address + ", " + email + ", " + phone + ", " + contactPerson;
    }

    @Override
    public List<Product> process() {
        System.out.println();
        System.out.println("Panie Prezesie, jako STAŁY dostawca nasza firma:");
        System.out.println(this.getName() + ", " + this.getAddress());
        System.out.println();
        System.out.println("wykona dostawę następującego asortymentu:");
        System.out.println();
        this.products.stream()
               .forEach(System.out::println);
        return new ArrayList<>(products);
    }
}
