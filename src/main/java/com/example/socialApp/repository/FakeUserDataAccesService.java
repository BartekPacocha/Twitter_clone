package com.example.socialApp.repository;

import com.example.socialApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeUserDataAccesService {

    private static List<User> UserList = new ArrayList<>();

    public void addUser(User user) {
        UserList.add(user);
    }

    public User find(String userid) {
        return UserList.stream()
                .filter(u -> u.getUserId().equals(userid))
                .findAny()
                .orElse(null);
    }

    public int follow(User user, User follow) {
        try {
            user.getFollowing().add(follow);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
