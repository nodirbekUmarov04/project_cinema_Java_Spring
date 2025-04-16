package com.example.cinema.service;


import com.example.cinema.entity.User;
import com.example.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();  // Получение всех пользователей
    }

    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setCreatedAt(user.getCreatedAt());
                    existingUser.setRoles(user.getRoles());
                    return userRepository.save(existingUser);
                })
                .orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}