package com.blogging.blogapplication.Services;

import java.util.List;
import com.blogging.blogapplication.Payloads.PostDto;

public interface PostService {

    // functions of the postservice

    // add post
    PostDto createPost(PostDto postDto, Long userid, Long categoryid);

    // delete post
    void deletePost(Long postid);

    // update post
    PostDto updatePost(PostDto postDto, Long postid);

    // get post by id
    PostDto getPostById(Long postid);

    // get all posts
    List<PostDto> getAllPosts();

    // fetch all posts of a user -> user posts page
    List<PostDto> getAllUserPosts(Long userid);

    // fetch all posts of a category -> for showing a category blog page
    List<PostDto> getAllCategoryPosts(Long postid);

    // search posts
    PostDto searchPost(String keyword);

}
