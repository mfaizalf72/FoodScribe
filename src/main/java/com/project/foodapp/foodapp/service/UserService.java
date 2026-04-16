package com.project.foodapp.foodapp.service;

import com.project.foodapp.foodapp.dto.UserRegistrationDTO;
import com.project.foodapp.foodapp.entity.User;
import com.project.foodapp.foodapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import com.project.foodapp.foodapp.dto.LoginDTO;
import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserRegistrationDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            return "Email already registered!";
        }

        if (userRepository.existsByMobileNumber(dto.getMobileNumber())) {
            return "Mobile number already registered!";
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setRegDate(LocalDateTime.now());

        userRepository.save(user);

        return "User registered successfully!";
    }

    public String loginUser(LoginDTO dto) {

        // Find user by email
        Optional<User> userOptional = userRepository.findByEmail(dto.getEmail());

        // If no user found with that email
        if (userOptional.isEmpty()) {
            return "Invalid email or password!";
        }

        User user = userOptional.get();

        // Check if password matches
        if (!user.getPassword().equals(dto.getPassword())) {
            return "Invalid email or password!";
        }

        return "Login successful! Welcome " + user.getFirstName();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}