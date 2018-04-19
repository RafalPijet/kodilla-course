package com.kodilla.good.patterns.airlines;

import java.util.Objects;

public class Blimp implements AirShip {

    private String name;
    private String idBlimp;
    private final int FLIGHT_SPEED = 100;
    private int availablePlaces;

    public Blimp(final String name, final String idBlimp, final int availablePlaces) {
        this.name = name;
        this.idBlimp = idBlimp;
        this.availablePlaces = availablePlaces;
    }

    @Override
    public String fly() {
        String info =  "nr lotu: " + idBlimp + ",\t" + FLIGHT_SPEED + " km/h, miejsc: " + availablePlaces + ",\t" + name;
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blimp blimp = (Blimp) o;
        return Objects.equals(name, blimp.name) &&
                Objects.equals(idBlimp, blimp.idBlimp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idBlimp);
    }
}
