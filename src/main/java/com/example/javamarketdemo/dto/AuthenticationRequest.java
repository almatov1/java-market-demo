package com.example.javamarketdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequest {
    private String mail;
    private String password;
}
