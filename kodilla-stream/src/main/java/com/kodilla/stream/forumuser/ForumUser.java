package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private final int userID;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postQuantity;

    public ForumUser(final int userID, final String username, final char sex, final int year, final int month, final int day, final int postQuantity) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.birthDate = LocalDate.of(year, month, day);
        this.postQuantity = postQuantity;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public String toString() {
        return "UserID: " + userID + ", username: " + username + ", sex: " + sex + ", birthDate: " + birthDate + ", postQuantity: " + postQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return userID == forumUser.userID &&
                sex == forumUser.sex &&
                postQuantity == forumUser.postQuantity &&
                Objects.equals(username, forumUser.username) &&
                Objects.equals(birthDate, forumUser.birthDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userID, username, sex, birthDate, postQuantity);
    }
}
