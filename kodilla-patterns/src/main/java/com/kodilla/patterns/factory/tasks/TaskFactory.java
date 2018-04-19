package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public final static String SHOPPING = "SHOPPING";
    public final static String PAINTING = "PAINTING";
    public final static String DRIVING = "DRIVING";

    public Task makeTask(String TaskClass) {
        switch (TaskClass) {
            case SHOPPING: {
                return new ShoppingTask("Purchase wooden furniture", "the furniture", 2d);
            }
            case PAINTING: {
                return new PaintingTask("Painting a speedboat", "blue", "The motorboat");
            }
            case DRIVING: {
                return new DrivingTask("Return to home", "tour", "car");
            }
            default: {
                return null;
            }
        }
    }

}
