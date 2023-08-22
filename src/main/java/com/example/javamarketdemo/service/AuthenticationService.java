package com.example.javamarketdemo.service;

import com.example.javamarketdemo.dto.AuthenticationRequest;
import com.example.javamarketdemo.dto.RegisterRequest;
import com.example.javamarketdemo.entity.Role;
import com.example.javamarketdemo.entity.User;
import com.example.javamarketdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        var user = new User()
                .setMail(request.getMail())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setRole(Role.ROLE_USER);
        repository.save(user);
        return "User successfully registered";
    }


    public String authenticate(AuthenticationRequest request) {
        log.info("authenticate function started");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getMail(),
                            request.getPassword()
                    )
            );
            log.info("authenticate data checked");

            User user = repository.findByMail(request.getMail())
                    .orElseThrow();
            log.info("Found user by mail: {}", user.getMail());

            String token = jwtService.generateToken(user);
            log.info("generated token: {}", token);

            return token;
        } catch (AuthenticationException e) {
            log.error("Authentication error: {}", e.getMessage());
            return e.getMessage();
        }
    }
}
