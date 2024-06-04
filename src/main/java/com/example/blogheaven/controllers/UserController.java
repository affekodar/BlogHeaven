package com.example.blogheaven.controllers;

import com.example.blogheaven.entities.Post;
import com.example.blogheaven.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private PostService postService;


    @PostMapping("/newpost")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
      Post newPost = postService.addPost(post);
      return ResponseEntity.ok(newPost);
    }

    @PutMapping("/updatepost/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(id, post));
    }



    @DeleteMapping("/deletepost/{id}")
    public String deletePostById(@PathVariable int id) {
        Post post = postService.fetchPostById(id);
        postService.deletePostById(id);
        return "Post with title: " + post.getTitle() + " and id " + id + " has been deleted.";
    }

}
