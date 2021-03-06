package com.example.springsecuritytdd.ui;

import com.example.springsecuritytdd.application.UserService;
import com.example.springsecuritytdd.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello every one!";
    }

    @GetMapping("/me")
    public User getMyMemberInfo() {
        return userService.getMyInfo();
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
