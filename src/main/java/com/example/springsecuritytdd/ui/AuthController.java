package com.example.springsecuritytdd.ui;

import com.example.springsecuritytdd.application.AuthService;
import com.example.springsecuritytdd.domain.User;
import com.example.springsecuritytdd.dto.TokenDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public TokenDto login(@RequestBody User user) {
        System.out.println("hello1");
        return authService.login(user);
    }

    @PostMapping("/auth/signup")
    public User signup(@RequestBody User user) {
        System.out.println("hello2");
        return authService.signup(user);
    }

}
