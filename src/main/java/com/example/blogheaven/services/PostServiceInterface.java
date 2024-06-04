package com.example.blogheaven.services;

import com.example.blogheaven.entities.Posts;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostServiceInterface {
    List<Posts> fetchAllPosts();
    Optional<Posts> fetchPostById(int id);
    void deletePostById(int id);

}
