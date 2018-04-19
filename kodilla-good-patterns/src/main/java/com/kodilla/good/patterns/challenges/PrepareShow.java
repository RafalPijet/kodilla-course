package com.kodilla.good.patterns.challenges;

public class PrepareShow {

    public PrepareShow(Customer customer, TakeOrder takeOrder, ServiceOfWarehouse serviceOfWarehouse, DeliveryOfProducts deliveryOfProducts, InformationService informationService) {
        System.out.println("---------------------------------------------------------------");
        ProductOrderService productOrderService = new ProductOrderService(takeOrder, serviceOfWarehouse, deliveryOfProducts, informationService);
        System.out.println();
        OrderDto status = productOrderService.process(customer);
        System.out.println("\nSzczegóły zamówienia:");
        status.getOrder().showOrder();
        System.out.println("\nZamówienie zrealizowane? --> " + status.isCompleted());
        System.out.println();
        System.out.println("---------------------------------------------------------------");

    }
}
