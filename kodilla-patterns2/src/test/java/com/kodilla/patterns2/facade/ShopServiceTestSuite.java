package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.ItemDto;
import com.kodilla.patterns2.facade.api.OrderDto;
import com.kodilla.patterns2.facade.api.OrderFacade;
import com.kodilla.patterns2.facade.api.OrderProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTestSuite {

    @Autowired
    private ShopService shopService;
    @Autowired
    private OrderFacade orderFacade;

    @Test
    public void testShopServiceSubmitOrder() {
        long orderdId = shopService.openOrder(1L);
        System.out.println("Registering new order, ID: " + orderdId);
        if (orderdId > 0) {
            shopService.addItem(orderdId, 10L, 2);
            System.out.println("Adding item: 10, 2 pcs");
            shopService.addItem(orderdId, 216L, 1);
            System.out.println("Adding item: 216,  pc");
            shopService.addItem(orderdId, 25L, 1);
            System.out.println("Adding item: 25, 1 pc");
            shopService.addItem(orderdId, 100L, 2.5);
            System.out.println("Adding item: 100, 2.5 pcs");
            shopService.addItem(orderdId, 11L, 3);
            System.out.println("Adding item: 11, 3 pcs");
            if (shopService.removeItem(orderdId, 100L)) {
                System.out.println("Item 100 was deleted from order");
            } else {
                throw new IllegalStateException("Order data is corrupted");
            }
            BigDecimal value = shopService.calculateValue(orderdId);
            System.out.println("Order value is: " + value + " USD");
            if (shopService.doPayment(orderdId)) {
                System.out.println("Payment for order was done");
            } else {
                System.out.println("Payment was rejected");
            }
            if (shopService.verifyOrder(orderdId)) {
                System.out.println("Order is ready to submit");
            } else {
                System.out.println("Order cannot be submitted");
            }
            if (shopService.submitOrder(orderdId)) {
                System.out.println("Order submitted - have a nice day!");
            } else {
                System.out.println("Order not submitted - canceling");
                shopService.cancelOrder(orderdId);
                System.out.println("Order is cancelled");
            }
        } else {
            System.out.println("Access denied.User is not authenticated.");
        }
    }

    @Test
    public void testShopFacade() {
        OrderDto orderDto = new OrderDto();
        orderDto.addItem(new ItemDto(10L, 2));
        orderDto.addItem(new ItemDto(216L, 1));
        orderDto.addItem(new ItemDto(25L, 1));
        orderDto.addItem(new ItemDto(11L, 3));
        try {
            orderFacade.processOrder(orderDto, 1L);
        } catch (OrderProcessingException e) {

        }
    }
}
