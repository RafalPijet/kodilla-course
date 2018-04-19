package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private String shapeName;
    private int a, h;

    public Triangle(int a, int h) {
        this.shapeName = "Triangle";
        this.a = a;
        this.h = h;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return (double) a * h / 2;
    }

    @Override
    public String toString() {
        return "Triangle, field --> " + getField();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return a == triangle.a &&
                h == triangle.h &&
                Objects.equals(shapeName, triangle.shapeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeName, a, h);
    }
}
