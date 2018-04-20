package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PepperDecorator extends AbstractPizzaDecorator {

    public PepperDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(6));
    }

    @Override
    public String getConfiguration() {
        return super.getConfiguration() + " + Pepper(50g)";
    }
}
