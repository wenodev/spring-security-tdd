package com.example.springsecuritytdd.ui;

import com.example.springsecuritytdd.application.UserService;
import com.example.springsecuritytdd.domain.User;
import com.example.springsecuritytdd.security.JwtAccessDeniedHandler;
import com.example.springsecuritytdd.security.JwtAuthenticationEntryPoint;
import com.example.springsecuritytdd.security.TokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private TokenProvider tokenProvider;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @MockBean
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private final String EMAIL = "juwon@weno.com";
    private final String PASSWORD = "1234";

    @Test
    void getUsers_메소드는_모든_회원들과_200을_리턴한다() throws Exception {
        // 준비
        User user = new User(1L, EMAIL, PASSWORD);
        given(userService.getUsers()).willReturn(List.of(user));

        // 실행
        ResultActions perform = mockMvc.perform(get("/users"));
        // 검증
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1));
    }

}
