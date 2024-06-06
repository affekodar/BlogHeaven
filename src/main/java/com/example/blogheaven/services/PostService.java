package com.example.blogheaven.services;

import com.example.blogheaven.entities.Post;
import com.example.blogheaven.exceptions.ResourceNotFoundException;
import com.example.blogheaven.repositiories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> fetchAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post fetchPostById(int id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", id));
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(int id, Post post) {
        Post postToUpdate = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", id));

        if (post.getTitle() != null) {
            postToUpdate.setTitle(post.getTitle());
        }
        if (post.getContent() != null) {
            postToUpdate.setContent(post.getContent());
        }

        return postRepository.save(postToUpdate);
    }


    @Override
    public void deletePostById(int id) {
        postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", id));
        postRepository.deleteById(id);
    }
}
