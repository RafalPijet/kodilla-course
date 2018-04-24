package com.kodilla.patterns2.observer.homework;

public class Mentor implements TaskObserver {
    private final String mentorName;
    private final boolean isCool;
    private int taskCounter;

    public Mentor(String mentorName, boolean isCool) {
        this.mentorName = mentorName;
        this.isCool = isCool;
    }
    @Override
    public void update(Student student) {
        System.out.println(mentorName + ": New task to check from " + student.getName() + "\n" + " (total: " + student.getTasks().size() + " tasks)");
        taskCounter++;
    }

    public boolean isCool() {
        return isCool;
    }

    public int getTaskCounter() {
        return taskCounter;
    }
}
