package org.example.mydbcontroller.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.example.mydbcontroller.model.dto.TokenDto;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    public TokenDto generateAccessToken(AuthUser authUser){
        Date tokenExpire = new Date(System.currentTimeMillis() + 3600 * 1000);
        String token = Jwts.builder()
                .signWith(getSecretKey())
                .issuedAt(new Date())
                .subject(authUser.getUsername())
                .expiration(tokenExpire)
                .claims(Map.of())
                .compact();
        return TokenDto.builder()
                .token(token)
                .expiry(tokenExpire)
                .build();

    }
    public Claims extractClaims(String refreshToken){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(refreshToken)
                .getPayload();
    }
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor("bu_secret_key_u_kamida_32_xona_bolishi_shartdir".getBytes());
    }

}
