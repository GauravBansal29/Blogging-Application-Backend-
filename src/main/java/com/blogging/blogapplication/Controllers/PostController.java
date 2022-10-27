package com.blogging.blogapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogging.blogapplication.Payloads.PostDto;
import com.blogging.blogapplication.Services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/{userid}/{categoryid}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long userid,
            @PathVariable Long categoryid) {
        PostDto createdPost = postService.createPost(postDto, userid, categoryid);
        return new ResponseEntity<>(createdPost, null, HttpStatus.CREATED);
    }

}
