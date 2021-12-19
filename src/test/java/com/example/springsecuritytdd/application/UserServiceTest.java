package com.example.springsecuritytdd.application;


import com.example.springsecuritytdd.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceTest {
    UserService userService = new UserService();

    @Test
    void getUsers_메소드는_모든_회원을_리턴한다(){
        List<User> users = userService.getUsers();
    }
}
