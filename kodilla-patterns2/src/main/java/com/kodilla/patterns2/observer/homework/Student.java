package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Student implements TaskObservable {
    private final String name;
    private final Deque<Task> tasks;
    private final List<TaskObserver> observers;

    public Student(String name) {
        this.name = name;
        tasks = new ArrayDeque<>();
        observers = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.offer(task);
        notifyTaskObservers();
    }
    @Override
    public void registerTaskObserver(TaskObserver taskObserver) {
        observers.add(taskObserver);
    }
    @Override
    public void notifyTaskObservers() {
        observers.stream()
                .forEach(taskObserver -> taskObserver.update(this));
    }
    @Override
    public void removeTaskObserver(TaskObserver taskObserver) {
        observers.remove(taskObserver);
    }

    public String getName() {
        return name;
    }

    public Deque<Task> getTasks() {
        return tasks;
    }

    public List<TaskObserver> getObservers() {
        return observers;
    }
}
