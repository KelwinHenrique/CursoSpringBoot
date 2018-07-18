package com.neppo.cursospringboot.CursoSpringBoot.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    @Value("{$jwt.secret}")
    private String secret;



    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() +60000 ))
                .signWith(SignatureAlgorithm.HS512,secret.getBytes())
                .compact();
    }


}
