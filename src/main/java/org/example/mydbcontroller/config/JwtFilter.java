package org.example.mydbcontroller.config;

import io.jsonwebtoken.Claims;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.config.jwt.JwtUtil;
import org.example.mydbcontroller.model.entity.AuthPermission;
import org.example.mydbcontroller.model.entity.AuthRole;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.example.mydbcontroller.repository.AuthUserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {


    private final JwtUtil jwtUtil;
    private final AuthUserRepository authUserRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getHeader("Authorization") != null){
            String token = request.getHeader("Authorization");
            Claims claims = jwtUtil.validateTokenAndExtract(token);
            String username = claims.getSubject();
            AuthUser authUser = authUserRepository.findByUsernameAndDeletedFalse(username).orElseThrow(
                    () -> new BadCredentialsException("Invalid username or password")
            );
            List<GrantedAuthority> authorities = prepareAuthorities(authUser);
            CustomUserDetails userDetails = new CustomUserDetails(claims.getSubject(), null, authUser.getId(), authorities);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
            }

        filterChain.doFilter(request,response);
        }
    private List<GrantedAuthority> prepareAuthorities(AuthUser authUser) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        AuthRole role = authUser.getRole();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        List<AuthPermission> permissions = role.getPermissions();
        permissions.forEach(p -> {
            authorities.add(new SimpleGrantedAuthority(p.getName()));
        });
        return authorities;
    }
}

