package org.example.mydbcontroller.controller;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.LoginRequest;
import org.example.mydbcontroller.dto.LoginResponse;
import org.example.mydbcontroller.service.AuthUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthUserService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponse> refreshToken(@RequestParam String refreshToken){
        return ResponseEntity.ok(service.refreshToken(refreshToken));
    }

}
