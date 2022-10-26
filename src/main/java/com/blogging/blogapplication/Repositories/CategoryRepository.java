package com.blogging.blogapplication.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogging.blogapplication.Entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
