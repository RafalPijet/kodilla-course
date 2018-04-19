package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Board {

    @Autowired
    @Qualifier("toDoList")
    private TaskList toDoList;

    @Autowired
    @Qualifier("inProgressList")
    private TaskList inProgressList;

    @Autowired
    @Qualifier("doneList")
    private TaskList doneList;

    public void addToDoList(String task) {
        this.toDoList.addTask(task);
    }

    public void addInProgressList(String task) {
        this.inProgressList.addTask(task);
    }

    public void addDoneList(String task){
        this.doneList.addTask(task);
    }

    public String getTaskFromToDoList() {
        return toDoList.getTask();
    }

    public String getTaskFromInProgressList() {
        return inProgressList.getTask();
    }

    public String getTaskFromDoneList() {
        return doneList.getTask();
    }
}
