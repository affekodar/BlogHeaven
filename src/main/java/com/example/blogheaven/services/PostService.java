package com.example.blogheaven.services;

import com.example.blogheaven.entities.Posts;

import com.example.blogheaven.repositiories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostServiceInterface{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Posts> fetchAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Posts> fetchPostById(int id) {
        return postRepository.findById(id);
    }

    @Override
    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }
}
