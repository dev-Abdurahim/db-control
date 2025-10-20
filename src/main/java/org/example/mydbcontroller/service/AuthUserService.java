package org.example.mydbcontroller.service;

import org.example.mydbcontroller.config.jwt.JwtUtil;
import org.example.mydbcontroller.model.dto.LoginRequest;
import org.example.mydbcontroller.model.dto.LoginResponse;
import org.example.mydbcontroller.model.dto.TokenDto;
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
        AuthUser authUser = repository.findByUsernameAndDeletedIsFalse(request.getUsername()).
                orElseThrow(
                        () -> new BadCredentialsException("Bad credentials")
                );
        if(!passwordEncoder.matches(request.getPassword(), authUser.getPassword())){
            throw new BadCredentialsException("Bad credentials");
        }
        TokenDto dto = jwtUtil.generateAccessToken(authUser);
        return LoginResponse.builder()
                .accessToken(dto.getToken())
                .accessTokenExpiration(dto.getExpiry())
                .build();

    }

















}
