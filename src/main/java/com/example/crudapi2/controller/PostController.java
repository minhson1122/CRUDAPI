package com.example.crudapi2.controller;

import com.example.crudapi2.model.Post;
import com.example.crudapi2.model.User;
import com.example.crudapi2.repository.PostRepository;
import com.example.crudapi2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
public class PostController {
@Autowired
    PostRepository postRepository;
@Autowired
    UserRepository userRepository;
@GetMapping
    public ResponseEntity<List<Post>> findAll(){
    return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
}
@PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post){
    return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
}
@PutMapping("/{id}")
    public ResponseEntity<Post> edit(@RequestBody Post post, @PathVariable Long id){
    post.setId(id);
    return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
}
@GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable Long id){
    return new ResponseEntity<>(postRepository.findById(id), HttpStatus.OK);
}
@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
    postRepository.deleteById(id);
    return new ResponseEntity<>("Delete Done",HttpStatus.OK);
}
    @GetMapping("/public")
    public ResponseEntity<List<Post>> getPublicPosts() {
        List<Post> publicPosts = postRepository.findAllByStatusContainingIgnoreCase("public");
        return new ResponseEntity<>(publicPosts, HttpStatus.OK);
    }

    @GetMapping("/only-me")
    public ResponseEntity<List<Post>> getOnlyMePosts() {
        List<Post> publicPosts = postRepository.findAllByStatusContainingIgnoreCase("only me");
        return new ResponseEntity<>(publicPosts, HttpStatus.OK);
    }
    @GetMapping("/sort-like")
    public ResponseEntity<List<Post>> sortLike(){
    List<Post> sort = postRepository.findAllByOrderByLikesDesc();
    return new ResponseEntity<>(sort,HttpStatus.OK);
    }
    @GetMapping("/top4like")
    public ResponseEntity<List<Post>> sortTop4(){
    List<Post> sort = postRepository.findTop4ByOrderByLikesDesc();
    return new ResponseEntity<>(sort,HttpStatus.OK);
    }

}
