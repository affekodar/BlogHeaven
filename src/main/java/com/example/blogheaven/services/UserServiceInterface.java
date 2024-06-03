package com.example.blogheaven.services;

import com.example.blogheaven.entities.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> fetchAllUsers();

    User addUser(User user);
}
