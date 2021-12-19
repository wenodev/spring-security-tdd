package com.example.springsecuritytdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    User user = new User();

    @Test
    void 유저는_이메일과_비밀번호가_있어야한다(){
        assertThat(user.getEmail()).isEqualTo("juwon@weno.com");
    }

}
