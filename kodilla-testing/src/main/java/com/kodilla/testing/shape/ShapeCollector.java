package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        shapes.add(shape);
        System.out.println("Dodano figurę --> " + shape);
    }

    public Shape removeFigure(Shape shape){
        Shape result = shape;
        if (shapes.contains(shape)) {
            result = shape;
            shapes.remove(shape);
            System.out.println("Usunięto figurę --> " + shape);
        } else {
            System.out.println("Brak na liście podanej figury do usunięcia");
        }
        return result;
    }

    public Shape removeFigureWithIndex(int i) {
        Shape result = null;
        if (i >= 0 && i < shapes.size()) {
            result = shapes.remove(i);
            System.out.println("Usunięto figurę --> " + result);
        } else {
            System.out.println("Brak na liście figury z indeksem " + i + " do usunięcia");
        }
        return result;
    }

    public Shape getFigure(int i) {
        Shape theFigure = null;
        if (i >= 0 && i < shapes.size()) {
            System.out.println("Pobrano figurę <-- " + shapes.get(i));
            theFigure = shapes.get(i);
        } else {
            System.out.println("Figura o indeksie " + i + " nie istnieje na liście");
        }
        return theFigure;
    }

    public ArrayList<Shape> showFigures() {
        if (shapes.size() > 0) {
            int counterShapes = 0;
            for (Shape shape : shapes) {
                counterShapes++;
                System.out.println("Figura nr " + counterShapes + " z " + shapes.size() + " --> " + shape);
            }
        } else {
            System.out.println("Lista nie zawiera żadnych figur");
        }
        return shapes;
    }

}
