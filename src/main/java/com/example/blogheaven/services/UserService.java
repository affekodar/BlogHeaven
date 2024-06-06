package com.example.blogheaven.services;

import com.example.blogheaven.entities.User;
import com.example.blogheaven.exceptions.ResourceNotFoundException;
import com.example.blogheaven.repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }


}
