package com.kodilla.patterns.strategy.social;

public class YGeneration extends User {
    public YGeneration(String user) {
        super(user);
        this.socialPublisher = new TwitterPublisher();
    }
}
