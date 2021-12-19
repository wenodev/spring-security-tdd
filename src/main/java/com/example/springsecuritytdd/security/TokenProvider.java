package com.example.springsecuritytdd.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;

public class TokenProvider {

    private final Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyByte = Decoders.BASE64.decode(secretKey);
        key = Keys.hmacShaKeyFor(keyByte);
    }

    public Key getKey() {
        return key;
    }
}
