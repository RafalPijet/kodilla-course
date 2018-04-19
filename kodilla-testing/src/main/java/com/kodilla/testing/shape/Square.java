package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private String shapeName;
    private int a;

    public Square(int a) {
        this.shapeName = "Square";
        this.a = a;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return (double) a * a;
    }

    @Override
    public String toString() {
        return "Square, field --> " + getField();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return a == square.a &&
                Objects.equals(shapeName, square.shapeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeName, a);
    }
}
