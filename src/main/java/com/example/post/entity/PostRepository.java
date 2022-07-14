package com.example.post.entity;

import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface PostRepository extends CrudRepository<Post, Long> {
    Optional<Post> findByUserName(String userName);
    List<Post> findAllByOrderByIdDesc(Pageable page);
}
