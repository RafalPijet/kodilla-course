package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    public static List<ForumUser> getUsersList() {
        List<ForumUser> usersList = new ArrayList<>();
        usersList.add(new ForumUser(1, "JackalPL", 'M', 1999, 10, 10, 5));
        usersList.add(new ForumUser(2, "LopezPL", 'M', 1973, 4, 22, 7));
        usersList.add(new ForumUser(3, "AgnesD", 'F', 1982, 9, 14, 12));
        usersList.add(new ForumUser(4, "JanetBAD", 'F', 1978, 3, 23, 1));
        usersList.add(new ForumUser(5, "RoxiAll", 'F', 2006, 2, 4, 21));
        usersList.add(new ForumUser(6, "ViWaldiRus", 'M', 2002, 11, 4, 2));
        usersList.add(new ForumUser(7,"PePe1980", 'M', 1980, 3, 7, 6));
        usersList.add(new ForumUser(8, "StolarPL", 'M', 1987, 8, 12, 0));
        usersList.add(new ForumUser(9, "DraculaRO", 'M', 2001, 1, 21, 3));
        usersList.add(new ForumUser(10, "OceanFish", 'M', 2003, 2, 28, 0));
        return new ArrayList<>(usersList);
    }
}
