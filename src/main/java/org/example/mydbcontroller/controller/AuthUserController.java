package org.example.mydbcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.model.dto.LoginRequest;
import org.example.mydbcontroller.model.dto.LoginResponse;
import org.example.mydbcontroller.service.AuthUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthUserService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(service.login(request));
    }

}
