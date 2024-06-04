package com.example.blogheaven.controllers;

import com.example.blogheaven.entities.Posts;
import com.example.blogheaven.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Posts>> getPosts() {
        return ResponseEntity.ok(postService.fetchAllPosts());
    }
     @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Posts>> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(postService.fetchPostById(id));
    }


    @DeleteMapping("/deletepost/{id}")
    public String deletePostById(@PathVariable int id) {
        Optional<Posts> post = postService.fetchPostById(id);
        postService.deletePostById(id);
        return "Post with title: " + post.get().getTitle() + " and id " + id + " has been deleted.";
    }

}
