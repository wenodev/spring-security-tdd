package com.example.springsecuritytdd.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TokenProviderTest {

    String secretKey = "wenosecretwenosecretwenosecretwenosecretwenosecretwenosecretwenosecret";
    TokenProvider tokenProvider = new TokenProvider(secretKey);

    @Test
    void 생성자는_주어진_secretKey가_있다면_Key를_만들어준다(){
        // 준비
        byte[] keyByte = Decoders.BASE64.decode(secretKey);
        Key key = Keys.hmacShaKeyFor(keyByte);

        assertThat(tokenProvider.getKey().getEncoded()).isEqualTo(key.getEncoded());
    }

}
