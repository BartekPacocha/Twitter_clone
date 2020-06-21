package com.example.socialApp;

import com.example.socialApp.model.User;
import com.example.socialApp.repository.FakeUserDataAccesService;
import com.example.socialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialAppApplication.class, args);
	}

}
