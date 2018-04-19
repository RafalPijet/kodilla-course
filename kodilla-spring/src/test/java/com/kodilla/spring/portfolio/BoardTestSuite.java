package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");
        Board board = context.getBean(Board.class);
        //When
        board.addToDoList("Zadanie do realizacji");
        board.addInProgressList("Zadanie w trakcie realizacji");
        board.addDoneList("Zadanie zrealizowane");
        String resultFromToDoList = board.getTaskFromToDoList();
        String resultFromInProgressList = board.getTaskFromInProgressList();
        String resultFromDoneList = board.getTaskFromDoneList();
        //Then
        Assert.assertEquals("Zadanie do realizacji", resultFromToDoList);
        Assert.assertEquals("Zadanie w trakcie realizacji", resultFromInProgressList);
        Assert.assertEquals("Zadanie zrealizowane", resultFromDoneList);
    }
}
