package com.example.socialApp.service;

import com.example.socialApp.model.Tweet;
import com.example.socialApp.model.User;
import com.example.socialApp.repository.FakeTweetDataAccesService;
import com.example.socialApp.repository.FakeUserDataAccesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetService {

    @Autowired
    private FakeTweetDataAccesService fakeTweetDataAccesService;
    @Autowired
    private FakeUserDataAccesService fakeUserDataAccesService;

    public List<Tweet> findAllUserTweets(String userid) {

        User user = fakeUserDataAccesService.find(userid);

        if (user == null) {
            return new ArrayList<>();
        }

        List<Tweet> res = fakeTweetDataAccesService.getTweetsForUser(user);
        if (res == null) {
            res = new ArrayList<>();
        }

        return res;
    }

    public void addTweet(String userid, String message) {

        User user = fakeUserDataAccesService.find(userid);

        if (user == null) {
            user = new User();
            fakeUserDataAccesService.addUser(user);
        }

        Tweet tweet = new Tweet(user, message);

        fakeTweetDataAccesService.addTweet(tweet);
    }

    public List<Tweet> findAllUserFollowTweets(String userid) {

        User user = fakeUserDataAccesService.find(userid);

        if (user == null) {
            return new ArrayList<>();
        }

        List<Tweet> res = fakeTweetDataAccesService.getFollowTweetsForUser(user);
        if (res == null) {
            res = new ArrayList<>();
        }

        return res;
    }
}
