package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private static int testsCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("POCZĄTEK ZESTAWU TESTÓW");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nKONIEC ZESTAWU TESTÓW");
    }

    @Before
    public void beforeTest() {
        testsCounter++;
        System.out.println("\nPoczątek przypadku testowego nr " + testsCounter);
    }

    @After
    public void afterTest() {
        System.out.println("Koniec przypadku testowego nr " + testsCounter);
    }

    @Test
    public void testZeroPostsCount() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość postów = 0");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();
        usersList.add("John Travolta");
        usersList.add("Jennifer Connelly");
        usersList.add("Scarlett Johansson");
        usersList.add("Brad Pitt");
        usersList.add("Camilla Belle");

        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(0);
        when(forumStatisticsMock.commentsCount()).thenReturn(0);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getCommentsQuantity();
        double answerAveragePostsAnUser = forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then
        Assert.assertEquals(5, quantityUsers);
        Assert.assertEquals(0, quantityPosts);
        Assert.assertEquals(0, quantityComments);
        Assert.assertEquals(quantityPosts / quantityUsers, answerAveragePostsAnUser, 1);
        Assert.assertEquals(0, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(quantityComments / quantityUsers, answerAverageCommentsAnUser, 1);

    }

    @Test
    public void testThousandPostsCount() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość postów = 1000");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();
        usersList.add("Jennifer Connelly");
        usersList.add("Scarlett Johansson");
        usersList.add("Camilla Belle");

        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(1000);
        when(forumStatisticsMock.commentsCount()).thenReturn(3678);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getCommentsQuantity();
        double answerAveragePostsAnUser = forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then
        Assert.assertEquals(3,quantityUsers);
        Assert.assertEquals(1000, quantityPosts);
        Assert.assertEquals(3678, quantityComments);
        Assert.assertEquals(quantityPosts / quantityUsers, answerAveragePostsAnUser, 1);
        Assert.assertEquals(quantityComments / quantityPosts, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(quantityComments / quantityUsers, answerAverageCommentsAnUser, 1);
    }

    @Test
    public void testZeroCommentsCount() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość komentarzy = 0");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            usersList.add("user_" + i);
        }

        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(367);
        when(forumStatisticsMock.commentsCount()).thenReturn(0);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getCommentsQuantity();
        double answerAveragePostsAnUser = forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then
        Assert.assertEquals(50, quantityUsers);
        Assert.assertEquals(367, quantityPosts);
        Assert.assertEquals(0, quantityComments);
        Assert.assertEquals(quantityPosts / quantityUsers, answerAveragePostsAnUser, 1);
        Assert.assertEquals(quantityComments / quantityPosts, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(quantityComments / quantityUsers, answerAverageCommentsAnUser, 1);
    }

    @Test
    public void testCommentsMoreThanPosts() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość komentarzy > ilości postów");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            usersList.add("user_" + i);
        }

        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(750);
        when(forumStatisticsMock.commentsCount()).thenReturn(820);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getCommentsQuantity();
        double answerAveragePostsAnUser = forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then

        Assert.assertEquals(24, quantityUsers);
        Assert.assertEquals(750, quantityPosts);
        Assert.assertEquals(820, quantityComments);
        Assert.assertEquals(quantityPosts / quantityUsers, answerAveragePostsAnUser, 1);
        Assert.assertEquals(quantityComments / quantityPosts, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(quantityComments / quantityUsers, answerAverageCommentsAnUser, 1);
    }

    @Test
    public void testPostsMoreThanComments() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość postów > ilości komentarzy");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();
        for (int i = 0; i < 74; i++) {
            usersList.add("user_" + i);
        }

        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(360);
        when(forumStatisticsMock.commentsCount()).thenReturn(220);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getCommentsQuantity();
        double answerAveragePostsAnUser = forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then

        Assert.assertEquals(74, quantityUsers);
        Assert.assertEquals(360, quantityPosts);
        Assert.assertEquals(220, quantityComments);
        Assert.assertEquals(quantityPosts / quantityUsers, answerAveragePostsAnUser, 1);
        Assert.assertEquals(quantityComments / quantityPosts, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(quantityComments / quantityUsers, answerAverageCommentsAnUser, 1);
    }

    @Test
    public void testZeroUsers() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość użytkowników = 0");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();

        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(0);
        when(forumStatisticsMock.commentsCount()).thenReturn(0);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getPostsQuantity();
        double answerAveragePostsAnUser = forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then
        Assert.assertEquals(0, quantityUsers);
        Assert.assertEquals(0, quantityPosts);
        Assert.assertEquals(0, quantityComments);
        Assert.assertEquals(0, answerAveragePostsAnUser, 1);
        Assert.assertEquals(0, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(0, answerAverageCommentsAnUser, 1);
    }

    @Test
    public void testHundredUsers() {
        //Given
        System.out.println("Badany przypadek testowy --> ilość użytkowników = 100");
        Statistics forumStatisticsMock = mock(Statistics.class);
        ArrayList<String> usersList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersList.add("user_" + i);
        }
        when(forumStatisticsMock.usersNames()).thenReturn(usersList);
        when(forumStatisticsMock.postsCount()).thenReturn(250);
        when(forumStatisticsMock.commentsCount()).thenReturn(782);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(forumStatisticsMock);
        forumStatistics.showStatistics();

        //When
        int quantityUsers = forumStatistics.getUsersQuantity();
        int quantityPosts = forumStatistics.getPostsQuantity();
        int quantityComments = forumStatistics.getCommentsQuantity();
        double answerAveragePostsAnUser =forumStatistics.getAveragePostsAnUser();
        double answerAverageCommentsAnPost = forumStatistics.getAverageCommentsAnPost();
        double answerAverageCommentsAnUser = forumStatistics.getAverageCommentsAnUser();

        //Then
        Assert.assertEquals(100, quantityUsers);
        Assert.assertEquals(250, quantityPosts);
        Assert.assertEquals(782, quantityComments);
        Assert.assertEquals(quantityPosts / quantityUsers, answerAveragePostsAnUser,1 );
        Assert.assertEquals(quantityComments / quantityPosts, answerAverageCommentsAnPost, 1);
        Assert.assertEquals(quantityComments / quantityUsers, answerAverageCommentsAnUser, 1);
    }
}
