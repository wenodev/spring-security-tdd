package com.example.springsecuritytdd.infra;

import com.example.springsecuritytdd.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@DataJpaTest
class UserRepositoryTest {

    @MockBean
    UserRepository userRepository;

    private final String EMAIL = "juwon@weno.com";
    private final String PASSWORD = "1234";

    @Test
    void 모든_회원을_조회한다(){
        User user = new User(1L, EMAIL, PASSWORD);
        given(userRepository.findAll()).willReturn(List.of(user));

        assertThat(user.getEmail()).isEqualTo(EMAIL);
    }

}