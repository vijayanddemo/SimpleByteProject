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

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) throws Exception {

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test", "root", "root");

        Statement stmt = conn.createStatement();

        // ❌ SQL Injection
        String query = "SELECT * FROM users WHERE id = '" + id + "'";
        ResultSet rs = stmt.executeQuery(query);

        return "Executed query";
    }
}
