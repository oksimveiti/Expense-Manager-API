package com.semihcetin.project.expensemanagerapi.controller;

import com.semihcetin.project.expensemanagerapi.entity.User;
import com.semihcetin.project.expensemanagerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user ) {
        return userService.createUser( user );
    }
}
