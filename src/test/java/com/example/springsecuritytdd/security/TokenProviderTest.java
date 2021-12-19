package com.example.springsecuritytdd.security;

import org.junit.jupiter.api.Test;

public class TokenProviderTest {

    String secretKey = "weno-secret";
    TokenProvider tokenProvider = new TokenProvider(secretKey);

    @Test
    void 생성자는_주어진_secretKey가_있다면_Key를_만들어준다(){

    }

}
