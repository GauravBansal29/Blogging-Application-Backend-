package com.blogging.blogapplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blogging.blogapplication.Payloads.PostDto;
import com.blogging.blogapplication.Payloads.PostPageResponse;
import com.blogging.blogapplication.Services.PostService;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    // create post
    @PostMapping("/{userid}/{categoryid}")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Long userid,
            @PathVariable Long categoryid) {
        PostDto createdPost = postService.createPost(postDto, userid, categoryid);
        return new ResponseEntity<>(createdPost, null, HttpStatus.CREATED);
    }

    // get all posts by userid
    @GetMapping("/user/{userid}")
    public ResponseEntity<PostPageResponse> getAllUserPosts(@PathVariable Long userid,
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "dir", defaultValue = "true", required = false) Boolean dir) {
        PostPageResponse postlist = postService.getAllUserPosts(userid, pageNumber, pageSize, sortBy, dir);
        return new ResponseEntity<>(postlist, null, HttpStatus.FOUND);
    }

    // get all posts by categoryid
    @GetMapping("/category/{categoryid}")
    public ResponseEntity<PostPageResponse> getAllCategoryPosts(@PathVariable Long categoryid,
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "dir", defaultValue = "true", required = false) Boolean dir) {
        PostPageResponse postList = postService.getAllCategoryPosts(categoryid, pageNumber, pageSize, sortBy, dir);
        return new ResponseEntity<>(postList, null, HttpStatus.FOUND);
    }

    // get all posts
    @GetMapping("/")
    public ResponseEntity<PostPageResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "dir", defaultValue = "true", required = false) Boolean dir) {
        PostPageResponse postlist = postService.getAllPosts(pageNumber, pageSize, sortBy, dir);
        return new ResponseEntity<>(postlist, null, HttpStatus.FOUND);
    }

    // get posts by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        PostDto postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto, null, HttpStatus.FOUND);
    }

    // update post
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Long id) {
        PostDto updatePost = postService.updatePost(postDto, id);
        return new ResponseEntity<>(updatePost, null, HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post has been deleted successfully", null, HttpStatus.OK);
    }

    // search posts by category
    @GetMapping("/search/{keyword}")
    public ResponseEntity<PostPageResponse> searchByCategory(
            @RequestParam(value = "category", defaultValue = "title", required = false) String category,
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "dir", defaultValue = "true", required = false) Boolean dir,
            @PathVariable String keyword) {
        PostPageResponse postlist = postService.searchPost(keyword, category, pageNumber, pageSize, sortBy, dir);
        return new ResponseEntity<>(postlist, null, HttpStatus.OK);
    }
}
