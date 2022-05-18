package com.chinesecooly.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    public static final Key JWT_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createJWT(String subject) {
        return Jwts.builder().setSubject(subject).signWith(JWT_KEY).compact();
    }

    public static Claims parseJWT(String jwt)  throws JwtException{
        return Jwts.parserBuilder().setSigningKey(JWT_KEY).build().parseClaimsJws(jwt).getBody();
    }
}