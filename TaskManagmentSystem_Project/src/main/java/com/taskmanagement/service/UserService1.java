package com.taskmanagement.service;

import com.taskmanagement.registration.User;
import com.taskmanagement.registration.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService1 implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true; 
        }
        return false; 
    }
}
