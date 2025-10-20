package org.example.mydbcontroller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db-user")

public class DbUserController {
    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }
}
