package org.example.mydbcontroller.utils;

import org.example.mydbcontroller.config.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
    public static CustomUserDetails sessionUser(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return (CustomUserDetails) authentication.getPrincipal();
    }
}
