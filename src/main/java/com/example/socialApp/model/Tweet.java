package com.example.socialApp.model;

import java.sql.Timestamp;
import java.util.UUID;


public class Tweet implements Comparable<Tweet> {

    private String tweetId;
    private Timestamp postTime;
    private User tweetAuthor;
    private String message;

    public Tweet(User user, String message) {
        this.message = message;
        this.tweetAuthor = user;
        this.tweetId = UUID.randomUUID().toString();
        this.postTime = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTweetId() {
        return tweetId;
    }

    public User getTweetAuthor() { return tweetAuthor; }

    @Override
    public int compareTo(Tweet o) {
        return postTime.compareTo(o.getPostTime());
    }
}
