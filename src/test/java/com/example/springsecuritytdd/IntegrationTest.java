package com.example.springsecuritytdd;

import com.example.springsecuritytdd.domain.User;
import com.example.springsecuritytdd.infra.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private UserRepository userRepository;

    private final String EMAIL = "juwon@weno.com";
    private final String PASSWORD = "1234";

    @BeforeEach
    void setUp(){
        userRepository.save( new User(1L, EMAIL, PASSWORD));
    }

    @Test
    void getUsers_메소드는_모든_회원들과_200을_리턴한다(){
        ResponseEntity<List> response = template.getForEntity("/users", List.class);
        assertThat(response.getBody().size()).isEqualTo(1);
    }

    @Test
    void signup_메소드는_email과_password가_유효하면_가입된_유저정보와_201을_리턴한다() throws Exception {
        // 준비

        // 실행
        ResponseEntity<User> response = template.postForEntity("/users", new User("juwon@weno.com", "1234") ,User.class);
        System.out.println("response: " + response);
    }
}
