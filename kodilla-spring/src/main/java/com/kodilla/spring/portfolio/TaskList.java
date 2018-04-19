package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskList {
    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public String getTask() {
        return tasks.get(0);
    }
}
