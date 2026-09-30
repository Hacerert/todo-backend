package org.example.todoappp.controller;

import org.example.todoappp.entity.User;
import org.example.todoappp.repository.UserRepository;
import org.example.todoappp.service.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthController(JwtService jwtService,
                          UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        User existingUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Şifre hatalı");
        }

        String token = jwtService.generateToken(existingUser.getUsername());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}