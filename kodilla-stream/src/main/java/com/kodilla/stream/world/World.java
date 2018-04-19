package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class World {
    private final List<Continent> continentsList = new ArrayList<>();

    public void addContinent(Continent continent) {
        continentsList.add(continent);
    }

    public List<Continent> getContinentsList() {
        return new ArrayList<>(continentsList);
    }

    public List<String> getNamesOfCountries() {
         List<String> namesList = getContinentsList().stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(country -> country.getNameOfCountry())
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("Kraje, które zostały uwzględnione w obliczeniach:");
         namesList.stream()
                 .forEach(System.out::println);
         return namesList;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal totalPeople = getContinentsList().stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, next) -> sum = sum.add(next));
        System.out.println("Liczba wszystkich ludzi na świecie --> " + totalPeople);
        return totalPeople;
    }
}
