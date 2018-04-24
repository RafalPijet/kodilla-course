package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.*;

public class MentorTestSuite {
    @Test
    public void testTaskUpdate() {
        //Given
        Student rafaello = new Student("student Rafaello");
        Student crazyFrog = new Student("student CrazyFrog");
        Student grimGravedigger = new Student("student GrimGravedigger");
        Mentor masterErwin = new Mentor("Master Erwin", true);
        Mentor boringDude = new Mentor("Boring Dude", false);
        rafaello.registerTaskObserver(masterErwin);
        crazyFrog.registerTaskObserver(masterErwin);
        grimGravedigger.registerTaskObserver(boringDude);
        //When
        rafaello.addTask(new Task("Ambition above all else", "While doing this task, be creative and not lazy"));
        rafaello.addTask(new Task("Kiss rule", "Do not overdo it with the development of functionality. Do only what is included in the content of the task"));
        crazyFrog.addTask(new Task("Be serious", "Life is not a continuous fun. Try to responsibly approach the assigned task."));
        crazyFrog.addTask(new Task("Repeat", "Stop laughing and read the task command again"));
        crazyFrog.addTask(new Task("Next reminder", "Think carefully whether your implementation of this solution is correct"));
        grimGravedigger.addTask(new Task("Do not be sullen", "Life is Beautiful. See how many great things you can learn"));
        //Then
        assertEquals(5, masterErwin.getTaskCounter());
        assertEquals(1, boringDude.getTaskCounter());
        assertTrue(masterErwin.isCool());//:)
    }
    @Test
    public void testRemoveObserver() {
        //Given
        Student rafaello = new Student("student Rafaello");
        Student crazyFrog = new Student("student CrazyFrog");
        Student grimGravedigger = new Student("student GrimGravedigger");
        Mentor masterErwin = new Mentor("Master Erwin", true);
        Mentor boringDude = new Mentor("Boring Dude", false);
        rafaello.registerTaskObserver(masterErwin);
        crazyFrog.registerTaskObserver(masterErwin);
        grimGravedigger.registerTaskObserver(boringDude);
        //When
        int mentorsQuantity = crazyFrog.getObservers().size();
        crazyFrog.removeTaskObserver(masterErwin);
        //Then
        assertEquals(1, mentorsQuantity);
        assertEquals(0, crazyFrog.getObservers().size());
    }
}
