package com.kodilla.good.patterns.airlines;

import java.util.Objects;

public class Arrival implements Flights {

    private int arrivalTime;
    private AirShip airShip;
    private Airport from;
    private Airport to;
    private String nameArrival;

    public Arrival(final int arrivalTime, final AirShip airShip, final Airport from, final Airport to) {
        this.arrivalTime = arrivalTime;
        this.airShip = airShip;
        this.from = from;
        this.to = to;
        nameArrival = to.getName() + " <-- " + from.getName();
    }

    @Override
    public Airport flyFrom() {
        return from;
    }

    @Override
    public Airport flyTo() {
        return to;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return  ",\t" + nameArrival + ", \t" + airShip.fly();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arrival arrival = (Arrival) o;
        return Objects.equals(airShip, arrival.airShip) &&
                Objects.equals(nameArrival, arrival.nameArrival);
    }

    @Override
    public int hashCode() {

        return Objects.hash(airShip, nameArrival);
    }
}
