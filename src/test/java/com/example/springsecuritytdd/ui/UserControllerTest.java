package com.example.springsecuritytdd.ui;

import com.example.springsecuritytdd.application.UserService;
import com.example.springsecuritytdd.security.JwtAccessDeniedHandler;
import com.example.springsecuritytdd.security.JwtAuthenticationEntryPoint;
import com.example.springsecuritytdd.security.TokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    void test() throws Exception {
    }

}
