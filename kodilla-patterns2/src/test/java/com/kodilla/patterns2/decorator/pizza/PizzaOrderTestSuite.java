package com.kodilla.patterns2.decorator.pizza;

import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaBasicGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println("(" + pizzaOrder.getConfiguration() + ") --> ALL COST --> " + theCost + "$");
        //Then
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testPizzaBasicGetConfig() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        //When
        String config = pizzaOrder.getConfiguration();
        //Then
        assertEquals("Pizza base", config);
    }

    @Test
    public void testPizzaWithHamOnionShrimpGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new ShrimpDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println("(" + pizzaOrder.getConfiguration() + ") --> ALL COST --> " + theCost + "$");
        //Then
        assertEquals(new BigDecimal(34), theCost);
    }

    @Test
    public void testPizzaWithHamOnionShrimpGetConfig() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new ShrimpDecorator(pizzaOrder);
        //When
        String config = pizzaOrder.getConfiguration();
        //Then
        assertEquals("Pizza base + Ham(100g) + Onion(70g) + Shrimp(90g)", config);
    }

    @Test
    public void testPizzaWithMozzarellaX2PepperTomatoesGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new MozzarellaDecorator(pizzaOrder);
        pizzaOrder = new MozzarellaDecorator(pizzaOrder);
        pizzaOrder = new PepperDecorator(pizzaOrder);
        pizzaOrder = new TomatoesDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println("(" + pizzaOrder.getConfiguration() + ") --> ALL COST --> " + theCost + "$");
        //Then
        assertEquals(new BigDecimal(35), theCost);
    }

    @Test
    public void testPizzaWithMozzarellaX2PepperTomatoesGetConfig() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new MozzarellaDecorator(pizzaOrder);
        pizzaOrder = new MozzarellaDecorator(pizzaOrder);
        pizzaOrder = new PepperDecorator(pizzaOrder);
        pizzaOrder = new TomatoesDecorator(pizzaOrder);
        //When
        String config = pizzaOrder.getConfiguration();
        //Then
        assertEquals("Pizza base + Mozzarella(70g) + Mozzarella(70g) + Pepper(50g) + Tomatoes(80g)", config);
    }
    @Test
    public void testPizzaWithAllGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MozzarellaDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new PepperDecorator(pizzaOrder);
        pizzaOrder = new ShrimpDecorator(pizzaOrder);
        pizzaOrder = new TomatoesDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        System.out.println("(" + pizzaOrder.getConfiguration() + ") --> ALL COST --> " + theCost + "$");
        //Then
        assertEquals(new BigDecimal(54), theCost);
    }
    @Test
    public void testPizzaWithAllGetConfig() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MozzarellaDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new PepperDecorator(pizzaOrder);
        pizzaOrder = new ShrimpDecorator(pizzaOrder);
        pizzaOrder = new TomatoesDecorator(pizzaOrder);
        //When
        String config = pizzaOrder.getConfiguration();
        //Then
        assertEquals("Pizza base + Ham(100g) + Mozzarella(70g) + Mushrooms(130g) + Onion(70g) + Pepper(50g) + Shrimp(90g) + Tomatoes(80g)", config);
    }
}
