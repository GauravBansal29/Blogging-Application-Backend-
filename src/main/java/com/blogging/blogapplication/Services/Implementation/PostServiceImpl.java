package com.blogging.blogapplication.Services.Implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.blogapplication.Entities.Category;
import com.blogging.blogapplication.Entities.Post;
import com.blogging.blogapplication.Entities.User;
import com.blogging.blogapplication.Exceptions.ResourceNotFoundException;
import com.blogging.blogapplication.Payloads.PostDto;
import com.blogging.blogapplication.Repositories.CategoryRepository;
import com.blogging.blogapplication.Repositories.PostRepository;
import com.blogging.blogapplication.Repositories.UserRepository;
import com.blogging.blogapplication.Services.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Long userid, Long categoryid) {

        User finduser = userRepo.findById(userid).orElseThrow(() -> {
            return new ResourceNotFoundException("User", "id", userid);
        });

        Category findcategory = categoryRepo.findById(categoryid).orElseThrow(() -> {
            return new ResourceNotFoundException("Category", "id", categoryid);
        });

        Post createdPost = modelMapper.map(postDto, Post.class);
        createdPost.setUser(finduser);
        createdPost.setCategory(findcategory);
        createdPost.setDate(new Date());
        postRepo.save(createdPost);

        return modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public void deletePost(Long postid) {
        Post findPost = postRepo.findById(postid).orElseThrow(() -> {
            return new ResourceNotFoundException("Post", "id", postid);
        });

        postRepo.delete(findPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postid) {

        Post findPost = postRepo.findById(postid).orElseThrow(() -> {
            return new ResourceNotFoundException("Post", "id", postid);
        });

        findPost.setTitle(postDto.getTitle());
        findPost.setContent(postDto.getContent());
        findPost.setImage(postDto.getImage());
        postRepo.save(findPost);

        return modelMapper.map(findPost, PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postid) {

        Post post = postRepo.findById(postid).orElseThrow(() -> {
            return new ResourceNotFoundException("Post", "id", postid);
        });

        return modelMapper.map(post, PostDto.class);

    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> postlist = (List<Post>) postRepo.findAll();
        List<PostDto> postdtoList = postlist.stream().map((post) -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        return postdtoList;
    }

    @Override
    public List<PostDto> getAllUserPosts(Long userid) {
        User finduser = userRepo.findById(userid).orElseThrow(() -> {
            return new ResourceNotFoundException("User", "id", userid);
        });
        List<Post> postlist = postRepo.findByUser(finduser);
        List<PostDto> postdtoList = postlist.stream().map((post) -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        return postdtoList;
    }

    @Override
    public List<PostDto> getAllCategoryPosts(Long categoryid) {

        Category findCategory = categoryRepo.findById(categoryid).orElseThrow(() -> {
            return new ResourceNotFoundException("Category", "id", categoryid);
        });
        List<Post> postlist = postRepo.findByCategory(findCategory);
        List<PostDto> postdtoList = postlist.stream().map((post) -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postdtoList;
    }

    @Override
    public PostDto searchPost(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

}
