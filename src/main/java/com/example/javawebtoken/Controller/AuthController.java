package com.example.javawebtoken.Controller;

import com.example.javawebtoken.Payload.AuthDto;
import com.example.javawebtoken.Service.AuthService;
import com.example.javawebtoken.token.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authController")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody AuthDto authDto){
//        UserDetails userDetails = authService.loadUserByUsername(authDto.getUserName());
//        boolean matches = passwordEncoder.matches(authDto.getPassword(),userDetails.getPassword());
//        boolean equals = userDetails.getPassword().equals(authDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getUserName(), authDto.getPassword()));
        if(authenticate.isAuthenticated()){
            return ResponseEntity.ok("Profilga xush kelibsiz!"+"\n"+tokenGenerator.getToken(authDto.getUserName()));
        }
        return ResponseEntity.status(401).body("Login yoki parol xato!");
    }

}
