package com.kodilla.good.patterns.airlines;

import java.util.Objects;

public class Helicopter implements AirShip {

    private String name;
    private String idHelicopter;
    private final int FLIGHT_SPEED = 300;
    private int availablePlaces;

    public Helicopter(final String name,final String idHelicopter, final int availablePlaces) {
        this.name = name;
        this.availablePlaces = availablePlaces;
        this.idHelicopter = idHelicopter;
    }

    @Override
    public String fly() {
        String info =  "nr lotu: " + idHelicopter + ",\t" + FLIGHT_SPEED + " km/h, miejsc: " + availablePlaces + ",\t" + name;
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helicopter that = (Helicopter) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(idHelicopter, that.idHelicopter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idHelicopter);
    }
}
