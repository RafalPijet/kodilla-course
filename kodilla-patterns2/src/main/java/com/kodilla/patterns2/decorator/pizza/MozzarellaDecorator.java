package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MozzarellaDecorator extends AbstractPizzaDecorator {

    public MozzarellaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getConfiguration() {
        return super.getConfiguration() + " + Mozzarella(70g)";
    }
}
