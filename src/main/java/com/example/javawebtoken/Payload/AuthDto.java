package com.example.javawebtoken.Payload;

import lombok.Data;

@Data
public class AuthDto {
    private String userName;
    private String password;
}
