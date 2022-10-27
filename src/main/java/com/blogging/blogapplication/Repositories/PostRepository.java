package com.blogging.blogapplication.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogging.blogapplication.Entities.Post;
import com.blogging.blogapplication.Entities.User;
import com.blogging.blogapplication.Entities.Category;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    // custom finder methods in JPA in case of relationships
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
