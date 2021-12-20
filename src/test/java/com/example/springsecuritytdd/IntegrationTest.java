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
        userRepository.save(User.builder()
                .id(1L)
                .email(EMAIL)
                .password(PASSWORD)
                .build()
        );
    }

    @Test
    void getUsers_메소드는_모든_회원들과_200을_리턴한다(){
        ResponseEntity<List> response = template.getForEntity("/users", List.class);
    }

}
