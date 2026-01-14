package com.fazon.simplybytespringboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
@AllArgsConstructor
public class TestingController {

    // ✅ Normal endpoint
    @GetMapping
    public String health() {
        return "Hello Everyone, Pipeline Working";
    }

    // ❌ No validation (Bug / Code Smell)
    @GetMapping("/age")
    public String age(@RequestParam int age) {
        return "Age: " + age;
    }

    // ❌ Hard-coded secret (CRITICAL Vulnerability)
    private static final String DB_PASSWORD = "admin123";

    // ❌ Sensitive data exposure
    @GetMapping("/password")
    public String showPassword() {
        return "Password is " + DB_PASSWORD;
    }
}
