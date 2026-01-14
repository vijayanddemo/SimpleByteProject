package com.fazon.simplybytespringboot.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
@AllArgsConstructor
public class TestingController {

    @GetMapping
    public String health() {
    return "Hello Everyone, Pipeline Working";
    }

    @GetMapping("/age")
    public String age(@RequestParam int age) {
    return "Age: " + age; // ❌ no validation
    }

    private static final String DB_PASSWORD = "admin123"; // ❌ hard-coded secret

    @GetMapping
    public String health() {
        return "Password is " + DB_PASSWORD;
    }
}
