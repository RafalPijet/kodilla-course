package com.kodilla.good.patterns.airlines;

import java.util.Objects;

public class Departure implements Flights {

    private int departureTime;
    private AirShip airShip;
    private Airport from;
    private Airport to;
    private String nameDeparture;

    public Departure(final int departureTime, final AirShip airShip, final Airport from, final Airport to) {
        this.departureTime = departureTime;
        this.airShip = airShip;
        this.from = from;
        this.to = to;
        nameDeparture = this.from.getName() + " --> " + this.to.getName();
    }

    @Override
    public Airport flyFrom() {
        return from;
    }

    @Override
    public Airport flyTo() {
        return to;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return  ",\t" + nameDeparture + ", \t" + airShip.fly();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departure departure = (Departure) o;
        return Objects.equals(airShip, departure.airShip) &&
                Objects.equals(nameDeparture, departure.nameDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airShip, nameDeparture);
    }
}
