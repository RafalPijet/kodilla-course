package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TomatoesDecorator extends AbstractPizzaDecorator {

    public TomatoesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }

    @Override
    public String getConfiguration() {
        return super.getConfiguration() + " + Tomatoes(80g)";
    }
}