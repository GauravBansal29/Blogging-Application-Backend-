package com.blogging.blogapplication.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogging.blogapplication.Entities.Post;
import com.blogging.blogapplication.Entities.User;
import com.blogging.blogapplication.Entities.Category;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // custom finder methods in JPA in case of relationships
    Page<Post> findByUser(User user, Pageable pageable);

    Page<Post> findByCategory(Category category, Pageable pageable);

    @Query("select p from Post p where p.title like :key")
    Page<Post> searchByTitle(@Param("key") String title, Pageable pageable);

    @Query("select p from Post p where p.content like :key")
    Page<Post> searchByContent(@Param("key") String content, Pageable pageable);

}
