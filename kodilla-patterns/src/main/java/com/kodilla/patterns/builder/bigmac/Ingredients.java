package com.kodilla.patterns.builder.bigmac;

public enum Ingredients {
    SALAD("SALAD"),
    ONION ("ONION"),
    BACON ("BACON"),
    CUCUMBER("CUCUMBER"),
    CHILLI("CHILLI"),
    MUSHROOMS("MUSHROOMS"),
    SHRIMP("SHRIMP"),
    CHEESE("CHEESE");
    private String description;

    private Ingredients(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
