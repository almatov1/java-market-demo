package com.example.javamarketdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class MainController {
    @GetMapping("/admin")
    public String homeAdmin() {
        return "Hello admin";
    }

    @GetMapping("/user")
    public String homeUser() {
        return "Hello user";
    }

    @GetMapping("/authenticated")
    public String homeAuthenticated() {
        return "Hello authenticated user";
    }
}
