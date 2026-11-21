
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public LoginController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        if (username == null || password == null ||
                username.isBlank() || password.isBlank()) {
            throw new RuntimeException("Username and password are required");
        }

        var users = jdbcTemplate.queryForList(
                "SELECT user_id, username, password, role FROM users WHERE username = ?",
                username
        );

        if (users.isEmpty()) {
            throw new RuntimeException("Invalid username or password");
        }

        Map<String, Object> user = users.get(0);
        String storedPassword = (String) user.get("password");

        boolean valid;

        if (storedPassword.startsWith("$2a$") ||
                storedPassword.startsWith("$2b$") ||
                storedPassword.startsWith("$2y$")) {
            valid = encoder.matches(password, storedPassword);
        } else {
            valid = storedPassword.equals(password);

            if (valid) {
                String hashedPassword = encoder.encode(password);
                jdbcTemplate.update(
                        "UPDATE users SET password = ? WHERE user_id = ?",
                        hashedPassword, user.get("user_id")
                );
            }
        }

        if (!valid) {
            throw new RuntimeException("Invalid username or password");
        }

        return Map.of(
                "message", "Login successful",
                "user_id", user.get("user_id"),
                "username", user.get("username"),
                "role", user.get("role")
        );
    }
}
