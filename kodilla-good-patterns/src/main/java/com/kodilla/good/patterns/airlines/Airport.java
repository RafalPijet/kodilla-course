package com.kodilla.good.patterns.airlines;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airport {

    private String name;
    private List<Arrival> arrivalsList = new ArrayList<>();
    private List<Departure> departuresList = new ArrayList<>();

    public Airport(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Arrival> getArrivalsList() {
        return arrivalsList;
    }

    public List<Departure> getDeparturesList() {
        return departuresList;
    }

    public void addDeparture(Departure departure) {
        departuresList.add(departure);
    }

    public void addArrival(Arrival arrival) {
        arrivalsList.add(arrival);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
