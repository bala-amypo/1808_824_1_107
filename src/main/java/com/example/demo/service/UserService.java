package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    User findByEmail(String email);

    // ADD THIS
    String login(String email, String password);
}
