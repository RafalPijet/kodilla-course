package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    private String shapeName;
    private int r;

    public Circle(int r) {
        this.shapeName = "Circle";
        this.r = r;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
         return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return "Circle, field --> " + getField();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return r == circle.r &&
                Objects.equals(shapeName, circle.shapeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeName, r);
    }
}
