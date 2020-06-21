package com.example.socialApp.repository;

import com.example.socialApp.model.Tweet;
import com.example.socialApp.model.User;

import java.util.List;

public interface TweetDao {

    List<Tweet> getTweetsForUser(User user);

    void addTweet(Tweet tweet);

}
