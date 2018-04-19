package com.kodilla.good.patterns.airlines;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CorporateAirConnections {

    private SmallAirlines smallAirlines = new SmallAirlines();

    public List<Departure> findDepartures(String airportName) {
        List<Departure> departuresList = smallAirlines.getAirports().stream()
                .flatMap(airport -> airport.getDeparturesList().stream())
                .filter(departure -> departure.flyFrom().getName() == airportName)
                .sorted(Comparator.comparing(departure -> departure.getDepartureTime()))
                .collect(Collectors.toList());
        return new ArrayList<>(departuresList);
    }

    public void showDepartures(List<Departure> departures) {
        System.out.println("\t\t\t\t\t\t\tO D L O T Y:");
        String textTime = null;
        for (Departure departure : departures) {
            textTime = String.valueOf(departure.getDepartureTime());
            if (textTime.length() == 3) {
                textTime = "0" + textTime;
            }
            textTime = textTime.substring(0, 2) + ":" + textTime.substring(2, 4);
            System.out.println(textTime + departure);
        }
    }

    public List<Arrival> findArrivals(String airportName) {
        List<Arrival> arrivalsList = smallAirlines.getAirports().stream()
                .flatMap(airport -> airport.getArrivalsList().stream())
                .filter(arrival -> arrival.flyTo().getName() == airportName)
                .sorted(Comparator.comparing(arrival -> arrival.getArrivalTime()))
                .collect(Collectors.toList());
        return new ArrayList<>(arrivalsList);
    }

    public void showArrivals(List<Arrival> arrivals) {
        System.out.println("\t\t\t\t\t\t\tP R Z Y L O T Y:");
        String textTime = null;
        for (Arrival arrival : arrivals) {
            textTime = String.valueOf(arrival.getArrivalTime());
            if (textTime.length() == 3) {
                textTime = "0" + textTime;
            }
            textTime = textTime.substring(0, 2) + ":" + textTime.substring(2, 4);
            System.out.println(textTime + arrival);
        }
    }

    public void betweenConnections(String airportFrom, String airportBetween, String airportTo) {
        List<Arrival> arrivals = findArrivals(airportBetween);
        List<Departure> departures = findDepartures(airportBetween);
        List<Arrival> answerArrivals = arrivals.stream()
                .filter(arrival -> arrival.flyFrom().getName() == airportFrom)
                .collect(Collectors.toList());
        List<Departure> answerDeparture = departures.stream()
                .filter(departure -> departure.flyTo().getName() == airportTo)
                .collect(Collectors.toList());
        if (answerArrivals.size() > 0) {
            showArrivals(answerArrivals);
        } else {
            System.out.println("Brak przylotów z " + airportFrom + " do " + airportBetween);
        }
        if (answerDeparture.size() > 0) {
            showDepartures(answerDeparture);
        } else {
            System.out.println("Brak wylotów do " + airportTo + " z " + airportBetween);
        }
    }
}
