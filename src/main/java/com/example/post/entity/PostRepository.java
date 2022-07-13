package com.example.post.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PostRepository extends CrudRepository<Post, Long> {
    Optional<Post> findById(Long id);
}
