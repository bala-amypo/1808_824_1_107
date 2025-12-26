package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.framework

@RestController
@RequestMapping("/auth")
public class AuthController {

@Autowired
    private final UserService userService;
    // private final PasswordEncoder passwordEncoder;

    // public AuthController(UserService userService,
    //                       PasswordEncoder passwordEncoder) {
    //     this.userService = userService;
    //     this.passwordEncoder = passwordEncoder;
    // }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        // if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        //     throw new RuntimeException("Invalid credentials");
        // }

        // UUID-based token (no JWT)
        String token = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        return new AuthResponse(token);
    }
}
