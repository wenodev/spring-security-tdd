package com.example.springsecuritytdd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long accessTokenExpiresIn;
    private String refreshToken;
}
