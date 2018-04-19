package com.kodilla.good.patterns.airlines;

import java.util.Objects;

public class Airplane implements AirShip {

    private String name;
    private String idAirplane;
    private final int FLIGHT_SPEED = 800;
    private int availablePlaces;

    public Airplane(final String name,final String idAirplane, final int availablePlaces) {
        this.name = name;
        this.availablePlaces = availablePlaces;
        this.idAirplane = idAirplane;
    }

    @Override
    public String fly() {
        String info =  "nr lotu: " + idAirplane + ",\t" + FLIGHT_SPEED + " km/h, miejsc: " + availablePlaces + ",\t" + name;
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(name, airplane.name) &&
                Objects.equals(idAirplane, airplane.idAirplane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idAirplane);
    }
}
