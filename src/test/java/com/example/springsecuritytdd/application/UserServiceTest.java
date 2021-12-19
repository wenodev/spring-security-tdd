package com.example.springsecuritytdd.application;


import com.example.springsecuritytdd.domain.User;
import com.example.springsecuritytdd.infra.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {
    UserRepository userRepository;
    UserService userService = new UserService();

    @Test
    void getUsers_메소드는_모든_회원을_리턴한다(){
        List<User> users = userService.getUsers();
        assertThat(users.size()).isEqualTo(2);
    }
}
