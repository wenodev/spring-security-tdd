package com.example.springsecuritytdd.config;

import com.example.springsecuritytdd.domain.Authority;
import com.example.springsecuritytdd.domain.User;
import com.example.springsecuritytdd.infra.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InitData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner myCLRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepository.save(User.builder()
                        .email("admin@admin.com")
                        .password(passwordEncoder.encode("1234"))
                        .authority(Authority.ROLE_ADMIN)
                        .build()
                );
            }
        };
    }
}
