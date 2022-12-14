package com.example.javawebtoken.Controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testController")
public class TestController {
    @GetMapping("/read")
    public HttpEntity<?> Read(){
        return ResponseEntity.ok("Hello");
    }
}
