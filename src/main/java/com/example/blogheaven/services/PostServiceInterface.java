package com.example.blogheaven.services;

import com.example.blogheaven.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostServiceInterface {
    List<Post> fetchAllPosts();
    Post fetchPostById(int id);
    Post addPost(Post post);
    Post updatePost(int id, Post post);
    void deletePostById(int id);

}
