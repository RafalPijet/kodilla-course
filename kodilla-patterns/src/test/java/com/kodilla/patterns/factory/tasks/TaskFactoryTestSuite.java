package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        boolean resultBefore = shopping.isTaskExecuted();
        shopping.executeTask();
        boolean resultAfter = shopping.isTaskExecuted();
        //Then
        Assert.assertFalse(resultBefore);
        Assert.assertTrue(resultAfter);
        Assert.assertEquals("Purchase wooden furniture", shopping.getTaskName());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        boolean resultBefore = painting.isTaskExecuted();
        painting.executeTask();
        boolean resultAfter = painting.isTaskExecuted();
        //Then
        Assert.assertFalse(resultBefore);
        Assert.assertTrue(resultAfter);
        Assert.assertEquals("Painting a speedboat", painting.getTaskName());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        boolean resultBefore = driving.isTaskExecuted();
        driving.executeTask();
        boolean resultAfter = driving.isTaskExecuted();
        //Then
        Assert.assertFalse(resultBefore);
        Assert.assertTrue(resultAfter);
        Assert.assertEquals("Return to home", driving.getTaskName());
    }
}
