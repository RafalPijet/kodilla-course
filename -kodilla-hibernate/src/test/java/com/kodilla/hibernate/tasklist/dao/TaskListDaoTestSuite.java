package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao repController;
    @Autowired
    private TaskDao taskDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskListToDo = new TaskList("To do tasks", "List with tasks to be carried out");
        TaskList taskListInProgress = new TaskList("In progress", "List with tasks in progress");
        TaskList taskListDone = new TaskList("Done", "List with completed tasks");
        repController.save(taskListToDo);
        repController.save(taskListInProgress);
        repController.save(taskListDone);
        //When
        String toDoList = taskListToDo.getListName();
        String inProgressList = taskListInProgress.getListName();
        String doneList = taskListDone.getListName();
        //Then
        Assert.assertEquals(toDoList, repController.findByListName(toDoList).get(0).getListName());
        Assert.assertEquals(inProgressList, repController.findByListName(inProgressList).get(0).getListName());
        Assert.assertEquals(doneList, repController.findByListName(doneList).get(0).getListName());
        //CleanUp
        repController.deleteAll();
    }
    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskListToDo = new TaskList("To do tasks", "List with tasks to be carried out");
        taskListToDo.getTasks().add(task1);
        taskListToDo.getTasks().add(task2);
        task1.setTaskList(taskListToDo);
        task2.setTaskList(taskListToDo);
        //When
        repController.save(taskListToDo);
        int id =taskListToDo.getId();
        //Then
        Assert.assertNotEquals(0, id);
        //CleanUp
        repController.delete(id);
    }
    @Test
    public void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Quaries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Makse some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList taskList = new TaskList("To do tasks", "List with tasks to be carried out");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        repController.save(taskList);
        int id = taskList.getId();

        //When
        List<Task> longTasks = taskDao.retriveLongTasks();
        List<Task> shortTasks = taskDao.retriveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retriveTasksWithEnoughTime();
        List<Task> durationLongerThanTasks = taskDao.retriveTasksWithDurationLongerThan(6);

        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
            repController.delete(id);
        }

    }
}
