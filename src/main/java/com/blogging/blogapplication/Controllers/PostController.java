package com.blogging.blogapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogging.blogapplication.Payloads.PostDto;
import com.blogging.blogapplication.Services.PostService;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    // create post
    @PostMapping("/{userid}/{categoryid}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long userid,
            @PathVariable Long categoryid) {
        PostDto createdPost = postService.createPost(postDto, userid, categoryid);
        return new ResponseEntity<>(createdPost, null, HttpStatus.CREATED);
    }

    // get all posts by userid
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<PostDto>> getAllUserPosts(@PathVariable Long userid) {
        List<PostDto> postlist = postService.getAllUserPosts(userid);
        return new ResponseEntity<>(postlist, null, HttpStatus.FOUND);
    }

    // get all posts by categoryid
    @GetMapping("/category/{categoryid}")
    public ResponseEntity<List<PostDto>> getAllCategoryPosts(@PathVariable Long categoryid) {
        List<PostDto> postList = postService.getAllCategoryPosts(categoryid);
        return new ResponseEntity<>(postList, null, HttpStatus.FOUND);
    }

    // get all posts
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> postlist = postService.getAllPosts();
        return new ResponseEntity<>(postlist, null, HttpStatus.FOUND);
    }

    // get posts by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        PostDto postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto, null, HttpStatus.FOUND);
    }

}
