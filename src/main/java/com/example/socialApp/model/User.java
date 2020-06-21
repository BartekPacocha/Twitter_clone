package com.example.socialApp.model;

import java.util.*;

public class User {

    private String userId;
    private String userName;
    private Set<User> following;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.following = new HashSet<>();
    }

    public User() {
        this.userId = UUID.randomUUID().toString();
        this.userName = userId.substring(0, 5);
        this.following = new HashSet<>();
    }

    public User(String userName, String id) {
        this.userId = id;
        this.userName = userName;
        this.following = new HashSet<>();
    }

    public Set<User> getFollowing() {
        return following;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

}
