package org.example.mydbcontroller.service;

import io.jsonwebtoken.Claims;
import org.example.mydbcontroller.config.jwt.JwtUtil;
import org.example.mydbcontroller.dto.LoginRequest;
import org.example.mydbcontroller.dto.LoginResponse;
import org.example.mydbcontroller.dto.TokenDto;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.example.mydbcontroller.repository.AuthUserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthUserService {
    private final AuthUserRepository repository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public AuthUserService(AuthUserRepository repository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request){
        AuthUser authUser = repository.findByUsername(request.getUsername()).
                orElseThrow(
                        () -> new BadCredentialsException("Bad credentials")
                );
        if(!passwordEncoder.matches(request.getPassword(), authUser.getPassword())){
            throw new BadCredentialsException("Bad credentials");
        }
        TokenDto accessToken = jwtUtil.generateAccessToken(authUser);
        TokenDto refreshToken = jwtUtil.generateRefreshToken(authUser);

        return LoginResponse.builder()
                .accessToken(accessToken.getToken())
                .accessTokenExpiration(accessToken.getExpiry())
                .refreshToken(refreshToken.getToken())
                .refreshTokenExpiration(refreshToken.getExpiry())
                .build();

    }

    public LoginResponse refreshToken(String refreshToken){
        Claims claims = jwtUtil.validateTokenAndExtract("Bearer " + refreshToken);
        String username = claims.getSubject();
        AuthUser authUser = repository.findByUsername(username).orElseThrow(
                () -> new BadCredentialsException("Bad credentials")
        );
        TokenDto accessToken = jwtUtil.generateAccessToken(authUser);

        return LoginResponse.builder()
                .accessToken(accessToken.getToken())
                .accessTokenExpiration(accessToken.getExpiry())
                .refreshToken(refreshToken)
                .refreshTokenExpiration(claims.getExpiration())
                .build();
    }
    }
