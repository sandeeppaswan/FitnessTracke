package com.project.fitness.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.List;
@Component
public class JwtUtils {
private String jwtSecret ="U3VwZXJTZWNvcmVMeEVtYmVkZGVkSGFzaEtleUZvckpXVEF1dGhlbnRpY2F0aW9uMjAyNlBfXw==";
private int jwtExpirationMs = 172800000;

public String getJwtFromHeader(HttpServletRequest request){
    String bearerToken = request.getHeader("Authorization");
    if(bearerToken != null && bearerToken.startsWith("Bearer "))
        return bearerToken.substring(7);
      return null;
}
public String generateToken(String userId, String role){

    return Jwts.builder()
            .subject(userId)
            .claim("roles" , List.of(new SimpleGrantedAuthority(role)))
            .issuedAt(new Date())
            .expiration(new Date(new Date().getTime() + jwtExpirationMs))
            .signWith(key())
            .compact();
}
public Key key(){

    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
}

    public boolean validateJwtToken(String jwtToken) {
    try{
        Jwts.parser().verifyWith((SecretKey)  key()).build().parseSignedClaims(jwtToken);
    }catch (Exception e){
        e.printStackTrace();
    }
    return true;
    }

    public String getUseridFromToken(String jwt) {
    return Jwts.parser().verifyWith((SecretKey) key())
            .build().parseSignedClaims(jwt)
            .getPayload().getSubject();
    }

    public Claims getAllClaims(String jwt) {
    return Jwts.parser().verifyWith((SecretKey) key())
            .build().parseSignedClaims(jwt).getPayload();
    }
}
