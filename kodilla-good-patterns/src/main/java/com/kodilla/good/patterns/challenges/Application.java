package com.kodilla.good.patterns.challenges;

public class Application {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Martin", "L. Gore", "52-600 Wąchock, al. Padniętych Lip 6", 608542369, "nocojest@op.pl");
        Customer customer2 = new Customer("David", "Gahan", "12-521 Stolec, ul. Grabarzy 23", 601236845, "ohoho@gmail.com");
        Customer customer3 = new Customer("Andrew", "Fletcher", "36-124 Grzybnia Mała, ul. Cmentarna 1", 686214568, "anflech@op.pl");

        new PrepareShow(customer1, new OnlineShop(), new WarehouseNumber1(), new CourierDHL(), new SendSMS());
        new PrepareShow(customer3, new Auction(), new WarehouseNumber1(), new CourierUPS(), new SendEmail());
        new PrepareShow(customer2, new StationaryShop(), new WarehouseNumber1(), new CourierUPS(), new SendEmail());
    }
}
