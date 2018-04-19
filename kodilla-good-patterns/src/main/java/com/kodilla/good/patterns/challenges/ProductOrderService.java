package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private TakeOrder takeOrder;
    private ServiceOfWarehouse serviceOfWarehouse;
    private DeliveryOfProducts deliveryOfProducts;
    private InformationService informationService;

    public ProductOrderService(final TakeOrder takeOrder, final ServiceOfWarehouse serviceOfWarehouse, final DeliveryOfProducts deliveryOfProducts, final InformationService informationService) {
        this.takeOrder = takeOrder;
        this.serviceOfWarehouse = serviceOfWarehouse;
        this.deliveryOfProducts = deliveryOfProducts;
        this.informationService = informationService;
    }

    public OrderDto process(Customer customer) {
        Order order = takeOrder.createOrder();
        CustomerOrder customerOrder = new CustomerOrder(customer, order);
        boolean isAccessOfProducts = serviceOfWarehouse.checkOrder(customerOrder.getOrder());
        if (isAccessOfProducts) {
            deliveryOfProducts.sendOrder(customerOrder);
            informationService.sendInfo(customerOrder);
            return new OrderDto(customerOrder.getCustomer(), customerOrder.getOrder(), true);
        } else {
            System.out.println("Brak w magazynie wszystkich produktów z zamówienia !!!");
            return new OrderDto(customerOrder.getCustomer(), customerOrder.getOrder(), false);
        }
    }
}
