package com.kodilla.patterns.strategy.social;

public class Milenials extends User {
    public Milenials(String user) {
        super(user);
        this.socialPublisher = new FacebookPublisher();
    }
}
