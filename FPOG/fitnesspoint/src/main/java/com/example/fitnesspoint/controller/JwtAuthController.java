package com.example.fitnesspoint.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesspoint.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class JwtAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String username = loginRequest.get("username");
            String password = loginRequest.get("password");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            String jwt = jwtUtil.generateToken(userDetails);
            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return response;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}