package com.kodilla.patterns.builder.bigmac;

public enum Sauces {
    STANDARD("STANDARD"),
    THOUSAND_ISLAND("THOUSAND_ISLAND"),
    BARBECUE("BARBECUE");
    private String description;

    private Sauces(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
