package com.kodilla.patterns.strategy.social;

public class User {
    private String user;
    protected SocialPublisher socialPublisher;

    public User(String user) {
        this.user = user;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void changePublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
