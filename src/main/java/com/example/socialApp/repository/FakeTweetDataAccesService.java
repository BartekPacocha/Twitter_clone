package com.example.socialApp.repository;

import com.example.socialApp.model.Tweet;
import com.example.socialApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FakeTweetDataAccesService implements TweetDao {

    private static List<Tweet> DB = new ArrayList<>();

    @Override
    public List<Tweet> getTweetsForUser(User user) {
        return DB.stream()
            .filter(db -> db.getTweetAuthor().equals(user))
            .collect(Collectors.toList());
    }

    @Override
    public void addTweet(Tweet tweet) {
        DB.add(tweet);
    }

    public List<Tweet> getFollowTweetsForUser(User user) {

        ArrayList<Tweet> res = new ArrayList<>();

        for (User u : user.getFollowing()) {

            ArrayList<Tweet> tmp = DB.stream()
                    .filter(db -> db.getTweetAuthor().equals(u))
                    .collect(Collectors.toCollection(ArrayList::new));

            res.addAll(tmp);
        }

        return res;

    }
}
