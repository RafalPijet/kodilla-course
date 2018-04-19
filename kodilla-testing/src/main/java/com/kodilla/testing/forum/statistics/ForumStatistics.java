package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averagePostsAnUser;
    private double averageCommentsAnUser;
    private double averageCommentsAnPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        if (usersQuantity > 0 && postsQuantity > 0) {
            averagePostsAnUser = (double) postsQuantity / usersQuantity;
            averageCommentsAnUser = (double) commentsQuantity / usersQuantity;
            averageCommentsAnPost = (double) commentsQuantity / postsQuantity;
        }

    }

    public void showStatistics() {
        System.out.println("Ilość użytkowników --> " + usersQuantity);
        System.out.println("Ilość postów --> " + postsQuantity);
        System.out.println("Ilość komentarzy --> " + commentsQuantity);
        System.out.printf("Średnia ilość postów na użytkownika --> " + "%5.2f", averagePostsAnUser);
        System.out.printf("\nŚrednia ilość komentarzy na użytkownika --> " + "%5.2f", averageCommentsAnUser);
        System.out.printf("\nŚrednia ilość komentarzy na post --> " + "%5.2f", averageCommentsAnPost);
        System.out.println();

    }

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAveragePostsAnUser() {
        return averagePostsAnUser;
    }

    public double getAverageCommentsAnUser() {
        return averageCommentsAnUser;
    }

    public double getAverageCommentsAnPost() {
        return averageCommentsAnPost;
    }
}
