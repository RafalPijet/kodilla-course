package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {
    public ZGeneration(String user) {
        super(user);
        this.socialPublisher = new SnapchatPublisher();
    }
}
