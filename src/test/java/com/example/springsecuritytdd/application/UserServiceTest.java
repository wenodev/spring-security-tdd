package com.example.springsecuritytdd.application;


import com.example.springsecuritytdd.domain.User;
import com.example.springsecuritytdd.infra.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UserServiceTest {
    UserRepository userRepository = mock(UserRepository.class);
    UserService userService = new UserService(userRepository);

    private final String EMAIL = "juwon@weno.com";
    private final String PASSWORD = "1234";

    @Test
    void getUsers_메소드는_모든_회원을_리턴한다(){
        // 준비
        User user = new User(1L, EMAIL, PASSWORD);
        given(userRepository.findAll()).willReturn(List.of(user));

        // 실행
        List<User> users = userService.getUsers();

        // 검증
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getEmail()).isEqualTo(EMAIL);
    }
}
