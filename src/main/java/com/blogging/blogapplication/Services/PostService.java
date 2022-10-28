package com.blogging.blogapplication.Services;

import java.util.List;
import com.blogging.blogapplication.Payloads.PostDto;
import com.blogging.blogapplication.Payloads.PostPageResponse;

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
    PostPageResponse getAllPosts(Integer pageNumber, Integer pageSize);

    // fetch all posts of a user -> user posts page
    PostPageResponse getAllUserPosts(Long userid, Integer pageNumber, Integer pageSize);

    // fetch all posts of a category -> for showing a category blog page
    PostPageResponse getAllCategoryPosts(Long postid, Integer pageNumber, Integer pageSize);

    // search posts
    PostDto searchPost(String keyword);

}
