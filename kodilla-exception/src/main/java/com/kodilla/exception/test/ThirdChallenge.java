package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class ThirdChallenge {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        boolean result = false;
        boolean checkKeyAndValue = false;
        Map<String, Boolean> flightsMap = new HashMap<>();

        Flight flight1 = new Flight("Bergamo", "Katowice");
        Flight flight2 = new Flight("Frankfurt nad Menem", "Paris");
        Flight flight3 = new Flight("Barcelona", "Amsterdam");
        Flight flight4 = new Flight("Wiedeń", "Moskwa");
        Flight flight5 = new Flight("Madryt", "Warszawa");

        flightsMap.put(flight1.getDepartureAirport(), true);
        flightsMap.put(flight2.getDepartureAirport(), false);
        flightsMap.put(flight3.getDepartureAirport(), true);
        flightsMap.put(flight4.getDepartureAirport(), true);
        flightsMap.put(flight5.getDepartureAirport(), false);

        for (Map.Entry entry : flightsMap.entrySet()) {
            if (entry.getKey() == flight.getDepartureAirport()) {
                result = true;
                if ((boolean) entry.getValue()) {
                    checkKeyAndValue = true;
                }
            }
        }
        if (!result) {
            throw new RouteNotFoundException("\nBłąd!!! Brak docelowego lotniska!!!");
        }
        return checkKeyAndValue;
    }

    public static void main(String[] args) {
        ThirdChallenge thirdChallenge = new ThirdChallenge();
        Flight searchFlight = new Flight("Oslo");
        try {
            boolean isDeparture = thirdChallenge.findFlight(searchFlight);
            if (isDeparture) {
                System.out.println("-----------------------------------------");
                System.out.println("Istnieje możliwość wylotu do " + searchFlight.getDepartureAirport());
            } else {
                System.out.println("-----------------------------------------");
                System.out.println("NIE istnieje możliwość wylotu do " + searchFlight.getDepartureAirport());
            }
        } catch (RouteNotFoundException rnfe) {
            System.out.println("WYJĄTEK: " + rnfe);
        } finally {
            System.out.println();
            System.out.println("---- INFORMACJE O ODLOTACH SAMOLOTÓW ----");

        }
    }

}
