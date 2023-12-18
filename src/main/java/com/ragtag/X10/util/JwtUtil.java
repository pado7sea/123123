package com.ragtag.X10.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final String SALT = "X10";

    // 토큰 유효시간 설정 (현재는 1시간)
    private static final long EXPIRATION_TIME = 3600 * 1000;

    // 토큰 생성 메서드
    public String createToken(String key, String value) throws UnsupportedEncodingException {
        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(key)
                .setIssuer("X10")
                .setAudience("X10")
                .setExpiration(expiration)
                .setIssuedAt(new Date())
                .claim(key, value)
                .signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
                .compact();
    }

    // 토큰 유효성 검사 메서드
    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
