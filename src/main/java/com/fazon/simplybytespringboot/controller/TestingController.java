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

}
