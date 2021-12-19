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
    void test(){
        ResponseEntity<List> response = template.getForEntity("/users", List.class);
        assertThat(response.getBody().size()).isEqualTo(1);
    }

}
