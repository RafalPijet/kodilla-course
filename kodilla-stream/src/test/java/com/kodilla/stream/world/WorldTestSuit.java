package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorldTestSuit {
    World world = new World();

    public void prepareWorld() {
        Continent europe = new Continent("Europa");
        europe.addCountry(new Country("Polska", new BigDecimal("38000000")));
        europe.addCountry(new Country("Niemcy", new BigDecimal("82000000")));
        europe.addCountry(new Country("Francja", new BigDecimal("67000000")));
        europe.addCountry(new Country("Hiszpania", new BigDecimal("48000000")));
        europe.addCountry(new Country("Włochy", new BigDecimal("60000000")));
        Continent africa = new Continent("Afryka");
        africa.addCountry(new Country("Egipt", new BigDecimal("97000000")));
        africa.addCountry(new Country("RPA", new BigDecimal("55000000")));
        africa.addCountry(new Country("Libia", new BigDecimal("6600000")));
        africa.addCountry(new Country("Zair", new BigDecimal("46500000")));
        africa.addCountry(new Country("Sudan", new BigDecimal("37300000")));
        Continent asia = new Continent("Azja");
        asia.addCountry(new Country("Rosja", new BigDecimal("144400000")));
        asia.addCountry(new Country("Chiny", new BigDecimal("1379000000")));
        asia.addCountry(new Country("Indie", new BigDecimal("1281900000")));
        asia.addCountry(new Country("Japonia", new BigDecimal("126450000")));
        asia.addCountry(new Country("Iran", new BigDecimal("78285000")));
        Continent northAmerica = new Continent("Ameryka Północna");
        northAmerica.addCountry(new Country("USA", new BigDecimal("323000000")));
        northAmerica.addCountry(new Country("Kanada", new BigDecimal("36708000")));
        northAmerica.addCountry(new Country("Meksyk", new BigDecimal("124574000")));
        Continent southAmerica = new Continent("Ameryka Południowa");
        southAmerica.addCountry(new Country("Brazylia", new BigDecimal("207353000")));
        southAmerica.addCountry(new Country("Argentyna", new BigDecimal("44293000")));
        southAmerica.addCountry(new Country("Peru", new BigDecimal("31000000")));
        southAmerica.addCountry(new Country("Chile", new BigDecimal("17789267")));
        southAmerica.addCountry(new Country("Kolumbia", new BigDecimal("47698524")));
        Continent australia = new Continent("Ausralia");
        australia.addCountry(new Country("Astralia", new BigDecimal("24511800")));
        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(australia);
    }
    @Test
    public void testGetPeopleQuantity() {
        //Given
        prepareWorld();
        List<String> expectedListNames = world.getContinentsList().stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(country -> country.getNameOfCountry())
                .collect(Collectors.toList());


        //When
        BigDecimal expectedResult = new BigDecimal("4404362591");
        BigDecimal resultFromWorld = world.getPeopleQuantity();
        List<String> resultListNames = world.getNamesOfCountries();

        //Then
        Assert.assertEquals(expectedResult, resultFromWorld);
        Assert.assertEquals(expectedListNames, resultListNames);
        Assert.assertTrue(resultListNames.contains("Sudan"));
        Assert.assertFalse(resultListNames.contains("Czechy"));
    }
}
