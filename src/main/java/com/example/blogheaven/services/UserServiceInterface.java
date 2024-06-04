package com.example.blogheaven.services;

import com.example.blogheaven.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<User> fetchAllUsers();
    User fetchUserById(int id);

    User addNewUser(User user);
}
