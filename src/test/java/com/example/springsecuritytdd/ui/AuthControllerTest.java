package com.example.springsecuritytdd.ui;

import com.example.springsecuritytdd.security.JwtAccessDeniedHandler;
import com.example.springsecuritytdd.security.JwtAuthenticationEntryPoint;
import com.example.springsecuritytdd.security.TokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenProvider tokenProvider;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @MockBean
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Test
    void signup_메소드는_email과_password가_유효하면_가입된_유저정보와_201을_리턴한다() throws Exception {
        // 준비

        // 실행
        ResultActions perform = mockMvc.perform(post("/signup"));

        // 과정
        perform.andExpect(status().isCreated());
    }

}
