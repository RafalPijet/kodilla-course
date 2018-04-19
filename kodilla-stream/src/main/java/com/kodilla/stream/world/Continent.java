package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String nameOfContinent;
    private final List<Country> countriesList = new ArrayList<>();

    public Continent(final String nameOfContinent) {
        this.nameOfContinent = nameOfContinent;
    }

    public void addCountry(Country country) {
        countriesList.add(country);
    }

    public List<Country> getCountriesList() {
        return new ArrayList<>(countriesList);
    }

    @Override
    public String toString() {
        return "kontynent --> " + nameOfContinent;
    }
}
