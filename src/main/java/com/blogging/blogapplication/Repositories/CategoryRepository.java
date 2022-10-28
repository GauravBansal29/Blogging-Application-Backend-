package com.blogging.blogapplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogging.blogapplication.Entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
