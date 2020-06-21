package com.example.socialApp.service;

import com.example.socialApp.model.User;
import com.example.socialApp.repository.FakeUserDataAccesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    FakeUserDataAccesService fakeUserDataAccesService;

    public User find(String userid) {
        return fakeUserDataAccesService.find(userid);
    }

    public int follow(String userid, String followid) {

        User user = find(userid);
        if (user == null) {
            return 0;
        }

        User follow = find(followid);
        if (follow == null) {
            return 0;
        }

        return fakeUserDataAccesService.follow(user, follow);
    }
}
