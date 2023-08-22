package com.example.javamarketdemo.service;

import com.example.javamarketdemo.entity.User;
import com.example.javamarketdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;

    public Optional<User> findByMail(String mail) {
        return repository.findByMail(mail);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        log.info("Custom loadUserByUsername touched");

        User user = findByMail(mail).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User not found by: %s", mail)
        ));

        org.springframework.security.core.userdetails.User systemUser = new org.springframework.security.core.userdetails.User(
                user.getMail(),
                user.getPassword(),
                user.getAuthorities()
        );

        log.info("Created userDetails: {}", systemUser.getUsername());

        return systemUser;
    }
}
