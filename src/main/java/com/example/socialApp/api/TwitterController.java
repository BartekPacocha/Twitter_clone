package com.example.socialApp.api;

import com.example.socialApp.model.Tweet;
import com.example.socialApp.service.TweetService;
import com.example.socialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TwitterController {

    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/", method = RequestMethod.GET)
    public List<Tweet> timeline(@RequestBody Map<String, String> json) {

        String userid = json.get("userid");

        return tweetService.findAllUserTweets(userid);
    }

    @RequestMapping(value = "/api/", method = RequestMethod.POST)
    public void tweet(@RequestBody Map<String, String> json) {

        String userid = json.get("userid");
        String message = json.get("message");

        tweetService.addTweet(userid, message);
    }

    @RequestMapping(value = "/api/follow/", method = RequestMethod.POST)
    public void follow(@RequestBody Map<String, String> json) {

        String userid = json.get("userid");
        String followid = json.get("followid");

        userService.follow(userid, followid);
    }

    @RequestMapping(value = "api/follow", method = RequestMethod.GET)
    public List<Tweet> getFollowTweets(@RequestBody Map<String, String> json) {

        String userid = json.get("userid");

        return  tweetService.findAllUserFollowTweets(userid);

    }

}
