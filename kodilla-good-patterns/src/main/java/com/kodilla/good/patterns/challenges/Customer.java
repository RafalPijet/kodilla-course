package com.kodilla.good.patterns.challenges;

public class Customer {

    private String name;
    private String surname;
    private String address;
    private int phoneNumber;
    private String email;

    public Customer(final String name, final String surname, final String address, final int phoneNumber, final String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " " + surname.toUpperCase() + '\'' + address + '\'' + phoneNumber + ", email='" + email;
    }
}
