package com.semihcetin.project.expensemanagerapi.service;

import com.semihcetin.project.expensemanagerapi.entity.User;
import com.semihcetin.project.expensemanagerapi.exception.ResourceNotFoundException;
import com.semihcetin.project.expensemanagerapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser( User user ) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User loginUser(com.semihcetin.project.expensemanagerapi.dto.LoginRequest loginRequest){
        // Do we have the user?
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Password check
        if (!user.getPassword().equals(loginRequest.getPassword())){
            throw new RuntimeException("Incorrect password");
        }

        // if successfully, return the user
        return user;

    }

}
