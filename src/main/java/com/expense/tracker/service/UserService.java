package com.expense.tracker.service;

import com.expense.tracker.dto.LoginDTO;
import com.expense.tracker.dto.RegisterDTO;
import com.expense.tracker.entity.User;
import com.expense.tracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public User login(LoginDTO dto) {

        Optional<User> user = userRepository.findByEmail(dto.getEmail());

        if (user.isPresent() &&
            user.get().getPassword().equals(dto.getPassword())) {

            return user.get();
        }

        throw new RuntimeException("Invalid Credentials");
    }
}