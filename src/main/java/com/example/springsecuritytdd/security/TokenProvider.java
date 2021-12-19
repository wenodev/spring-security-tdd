package com.example.springsecuritytdd.security;

import java.security.Key;

public class TokenProvider {

    private Key key;

    public TokenProvider(String secretKey) {

    }

    public Key getKey() {
        return key;
    }
}
