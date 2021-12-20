package com.example.springsecuritytdd.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private final String EMAIL = "juwon@weno.com";
    private final String PASSWORD = "1234";

    User user = new User(EMAIL, PASSWORD);

    @Test
    void 유저는_이메일과_비밀번호가_있어야한다(){
        assertThat(user.getEmail()).isEqualTo(EMAIL);
        assertThat(user.getPassword()).isEqualTo(PASSWORD);
    }

}
