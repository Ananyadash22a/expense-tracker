package com.expense.tracker.controller;

import com.expense.tracker.dto.LoginDTO;
import com.expense.tracker.dto.RegisterDTO;
import com.expense.tracker.entity.User;
import com.expense.tracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO dto) {
        return userService.login(dto);
    }
}