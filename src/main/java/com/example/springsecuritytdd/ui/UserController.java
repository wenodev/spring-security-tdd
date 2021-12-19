package com.example.springsecuritytdd.ui;

import com.example.springsecuritytdd.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers(){
        return null;
    }
}
