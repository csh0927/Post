package com.example.post.service;

import com.example.post.dto.PostRequest;
import com.example.post.dto.PostIdResponse;
import com.example.post.entity.Post;
import com.example.post.entity.PostRepository;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Builder
@Service
public class PostService {
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    public PostIdResponse postSave(PostRequest request){
        return new PostIdResponse(
                postRepository.save(
                        Post.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        ).getId());
    }
}
