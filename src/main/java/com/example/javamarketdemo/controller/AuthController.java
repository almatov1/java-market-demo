package com.example.javamarketdemo.controller;

import com.example.javamarketdemo.dto.AuthenticationRequest;
import com.example.javamarketdemo.dto.RegisterRequest;
import com.example.javamarketdemo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        log.info("authenticate function touched");
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/tick")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("tack");
    }
}
