package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString() {
        //Given
        //creating the TaskList for todos
        TaskList toDoList = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> toDoList.getTasks().add(new Task("To Do tasks number " + n)));
        //creating the TaskList for in progress
        TaskList inProgressList = new TaskList("In progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> inProgressList.getTasks().add(new Task("In progress tasks number " + n)));
        //creating the TaskList for done
        TaskList doneList = new TaskList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> doneList.getTasks().add(new Task("Done tasks number " + n)));
        //creating the board and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(toDoList);
        board.getLists().add(inProgressList);
        board.getLists().add(doneList);
        //making a shallow copy of object board
        Board boardClone = null;
        try {
            boardClone = board.shallowCopy();
            boardClone.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //making a deep copy of object board
        Board deepCloneBoard = null;
        try {
            deepCloneBoard = board.deepCopy();
            deepCloneBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        board.getLists().remove(toDoList);
        //Then
        System.out.println(board);
        System.out.println(boardClone);
        System.out.println(deepCloneBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, boardClone.getLists().size());
        Assert.assertEquals(3, deepCloneBoard.getLists().size());
        Assert.assertEquals(board.getLists(), boardClone.getLists());
        Assert.assertNotEquals(board.getLists(), deepCloneBoard.getLists());
    }
}
