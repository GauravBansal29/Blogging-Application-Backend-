package com.blogging.blogapplication.Payloads;

import java.util.Date;

import com.blogging.blogapplication.Entities.Category;
import com.blogging.blogapplication.Entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;

    private String title;

    private String content;

    private Date date;

    private String image;

    // we will not get but will have to return this
    private UserDto user;

    // we will not get but will have to return this
    private CategoryDto category;

}
