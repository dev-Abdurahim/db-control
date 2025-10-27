package org.example.mydbcontroller.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.example.mydbcontroller.dto.TokenDto;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    public TokenDto generateRefreshToken(AuthUser authUser){
        Date tokenExpire = new Date(System.currentTimeMillis() + 3600 * 48 * 1000);
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

    public TokenDto generateAccessToken(AuthUser authUser){
        Date tokenExpire = new Date(System.currentTimeMillis() + 3600 * 24 * 1000);
        String token = Jwts.builder()
                .signWith(getSecretKey())
                .issuedAt(new Date())
                .subject(authUser.getUsername())
                .expiration(tokenExpire)
                .claims(Map.of(
                        "userId",authUser.getId()
                ))
                .compact();
        return TokenDto.builder()
                .token(token)
                .expiry(tokenExpire)
                .build();

    }

    public Claims validateTokenAndExtract(String token){
        if(token == null || !token.startsWith("Bearer ")){
            throw new RuntimeException("Invalid token");
        }
        token = token.replaceFirst("Bearer ", "");
        Claims claims = extractClaims(token);
        if (claims.getExpiration().before(new Date()))
            throw new RuntimeException("Token is expired");

        return claims;
    }


    // Claims — bu JWT tokenning ichidagi ma’lumotlar (payload)ni ifodalovchi interface.
    public Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor("bu_secret_key_u_kamida_32_xona_bolishi_shartdir".getBytes());
    }

}
