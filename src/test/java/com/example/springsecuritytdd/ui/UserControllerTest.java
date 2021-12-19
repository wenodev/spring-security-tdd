package com.example.springsecuritytdd.ui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUsers_메소드는_모든_회원들과_200을_리턴한다() throws Exception {
        // 준비

        // 실행
        ResultActions perform = mockMvc.perform(get("/users"));
        // 검증
        perform.andExpect(status().isOk());
    }

}
