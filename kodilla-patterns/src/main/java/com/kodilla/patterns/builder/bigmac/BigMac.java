package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    public static final boolean YES = true;
    public static final boolean NO = false;
    private final boolean roll;
    private final int burgers ;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigMacBuilder {
        private boolean roll;
        private int burgers = 2;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMacBuilder giveRoll(boolean isSesame) {
            this.roll = isSesame;
            return this;
        }

        public BigMacBuilder giveBurgers(int burgers) {
            if (burgers >= 2) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("Quantity of burgers must be greather than two or equal!");
            }
            return this;
        }

        public BigMacBuilder giveSauce(String sauce) {
            for (Sauces sauceType : Sauces.values()) {
                if (sauceType.getDescription().equals(sauce)) {
                    this.sauce = sauce;
                }
            }
            if (this.sauce != sauce) {
                throw new IllegalStateException("Unavailable value for the sauce field!");
            }
            return this;
        }

        public BigMacBuilder giveIngredients(String ingedients) {
            for (Ingredients ingredientsType : Ingredients.values()){
                if (ingredientsType.getDescription().equals(ingedients)) {
                    ingredients.add(ingedients);
                }
            }
            if (!this.ingredients.contains(ingedients)) {
                throw new IllegalStateException("Unavailable value for the ingredients field!");
            }
            return this;
        }

        public BigMac build() {
            return new BigMac(roll, burgers, sauce, ingredients);
        }
    }

    private BigMac(final boolean isSesame, final int burgers, final String sauce, List<String> ingredients) {
        this.roll = isSesame;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean isSesame() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "withSesame=" + roll +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                "\ningredients=" + ingredients +
                '}';
    }
}
