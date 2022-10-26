package com.blogging.blogapplication.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogging.blogapplication.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
