package com.example.auth_api.service;

import com.example.auth_api.entity.User;
import com.example.auth_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User createUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}