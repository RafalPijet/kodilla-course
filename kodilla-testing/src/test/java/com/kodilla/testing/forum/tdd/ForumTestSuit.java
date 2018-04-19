package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuit {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        //When
        forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");
        //Then
        Assert.assertEquals(1, forumUser.getPostQuantity());
    }

    @Test
    public void testAddComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        //When
        forumUser.addComment(forumPost, "mrsmith", "Thank you for all good words!");
        //Then
        Assert.assertEquals(1, forumUser.getCommentQuantity());
    }

    @Test
    public void testGetPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
        //When
        ForumPost retrivedPost = forumUser.getPost(0);
        //Then
        Assert.assertEquals(forumPost, retrivedPost);
    }

    @Test
    public void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        ForumComment forumComment = new ForumComment(forumPost, "Thank you for all good words!", "mrsmith");
        forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());
        //When
        ForumComment retrivedComment = forumUser.getComment(0);
        //Then
        Assert.assertEquals(forumComment, retrivedComment);
    }

    @Test
    public void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        //When
        boolean result = forumUser.removePost(forumPost);
        //Then
        Assert.assertFalse(result);

    }

    @Test
    public void testRemoveCommentNotExidting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        ForumComment forumComment = new ForumComment(forumPost, "Thank you for all good words!", "mrsmith");
        //When
        boolean result = forumUser.removeComment(forumComment);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
        //When
        boolean result = forumUser.removePost(forumPost);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostQuantity());
    }

    @Test
    public void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
        ForumComment forumComment = new ForumComment(forumPost, "Thank you for all good words!", "mrsmith");
        forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());
        //When
        boolean result = forumUser.removeComment(forumComment);
        //When
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentQuantity());
    }
}
