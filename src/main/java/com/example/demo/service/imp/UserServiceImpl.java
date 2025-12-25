package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        if (user.getRole() == null) {
            user.setRole("AGENT");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setToken(generateToken());

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // ✅ LOGIN METHOD (NO JWT)
    @Override
    public String login(String email, String password) {

        User user = findByEmail(email);

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = generateToken();
        user.setToken(token);
        userRepository.save(user);

        return token;
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
