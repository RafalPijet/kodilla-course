package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.*;

public class ForumTestSuite {
    @Before
    public void before() {
        System.out.println("The case: begin");
    }
    @After
    public void after() {
        System.out.println("The case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("The suit: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("The suit: end");
    }
    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "David Gahan");
        //When
        String result = simpleUser.getUsername();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("theForumUser", result);
    }
    @Test
    public void testCaseRealname() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "David Gahan");
        //When
        String result = simpleUser.getRealname();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("David Gahan", result);
    }
}
